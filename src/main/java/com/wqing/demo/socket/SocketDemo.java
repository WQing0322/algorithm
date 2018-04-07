package com.wqing.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Scanner scanner = null;
        try {
            System.out.println("通信监听开始···");
            serverSocket = new ServerSocket(6666);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from" + clientSocket.getLocalSocketAddress());
                while (true) {
                    scanner = new Scanner(clientSocket.getInputStream());
                    String request = scanner.nextLine();
                    if ("quit".equals(request)) {
                        break;
                    }
                    String response = "Hello " + request + ".\n";
                    clientSocket.getOutputStream().write(response.getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("通信异常！");
        } finally {
            serverSocket.close();
            scanner.close();
        }

        System.out.println("通信监听结束···");
    }
}
