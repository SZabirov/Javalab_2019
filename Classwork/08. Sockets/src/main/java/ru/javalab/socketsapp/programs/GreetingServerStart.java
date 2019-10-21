package ru.javalab.socketsapp.programs;

import ru.javalab.socketsapp.servers.GreetingServer;

public class GreetingServerStart {
    public static void main(String[] args) {
        GreetingServer server = new GreetingServer();
        server.start(6000);
    }
}
