package main.java.com.introduction.coretechnology.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inputStream,"UTF-8")){
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outputStream,"UTF-8"),true);
                    out.println("hello !enter bye to exit");
                    boolean done = false;
                    while(!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: "+ line);
                        if(line.trim().equals("bye")) done =true;
                    }
                }
            }
        }
    }
}
