package ru.javalab.socketsapp.programs.multiclientchat;

import ru.javalab.socketsapp.clients.ChatClient;

import java.util.Scanner;

public class ChatClientMain {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.startConnection("127.0.0.1", 7000);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            chatClient.sendMessage(message);
        }
    }
}
