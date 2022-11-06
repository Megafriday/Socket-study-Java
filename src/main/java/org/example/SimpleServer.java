package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {

        var serverSocket = new ServerSocket(1600);
        System.out.println("Waiting");

        try(Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream()) {

            System.out.println("Connected from " + socket.getInetAddress());
            System.out.println(inputStream.read());
        }
    }
}