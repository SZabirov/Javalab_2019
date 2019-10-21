package ru.javalab.socketsapp.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            //accept - ждет подключения,
            //как только клиент подключен,
            //он помещается в clientSocket
            clientSocket = serverSocket.accept();
            //входной поток клиента
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            //считываем сообщение от клиента
            String s = reader.readLine();
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            if (s.equals("Hello!")) {
                writer.println("Hi!");
            } else {
                System.out.println("Unrecognized greeting");
            }
            System.out.println(s);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}




