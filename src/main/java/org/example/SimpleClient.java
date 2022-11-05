package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1600);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(234);

        socket.close();
        outputStream.close();
    }
}