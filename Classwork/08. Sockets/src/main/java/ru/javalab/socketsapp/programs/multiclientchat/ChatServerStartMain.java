package ru.javalab.socketsapp.programs.multiclientchat;

import ru.javalab.socketsapp.servers.MultiClientServer;

public class ChatServerStartMain {
    public static void main(String[] args) {
        MultiClientServer multiClientServer =
                new MultiClientServer();
        multiClientServer.start(7000);
    }
}
