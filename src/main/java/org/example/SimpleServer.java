package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {

        var server = new ServerSocket(1600);
        System.out.println("Waiting");

        Socket socket = server.accept();
        System.out.println("Connected from " + socket.getInetAddress());

        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream.read());

        socket.close();
        inputStream.close();
    }
}