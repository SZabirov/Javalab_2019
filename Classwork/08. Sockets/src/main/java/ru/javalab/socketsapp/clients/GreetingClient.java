package ru.javalab.socketsapp.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetingClient {
    private Socket clientSocket;

    //выполняем подключение к серверу с указанными адресом и портом
    public void startConnection(String ipAddress, int port) {
        try {
            clientSocket = new Socket(ipAddress, port);
            PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            writer.println("Hello!");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
