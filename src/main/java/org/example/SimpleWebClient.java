package org.example;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleWebClient {
    public static void main(String[] args) throws IOException {
        var domain = "example.com";
        var socketFactory = SSLSocketFactory.getDefault();

        try( var socket = socketFactory.createSocket(domain, 443);
             var printWriter = new PrintWriter(socket.getOutputStream());
             var inputStreamReader = new InputStreamReader(socket.getInputStream());
             var bufferedReader = new BufferedReader(inputStreamReader)){

            // Request を送信
            printWriter.println("GET /index.html HTTP/1.1");
            printWriter.println("HOST: " + domain);
            printWriter.println();
            printWriter.flush();

            // Response を受信
            bufferedReader.lines()
                    .limit(18)
                    .forEach(System.out::println);
        }
    }
}
