package main.java.com.introduction.io.demo;

import main.java.com.util.Constants;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Demo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        File inputFile = new File(prefixPath+"input.txt");
        File outputFile = new File(prefixPath+"output.txt");
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        IO.dump(fileInputStream, fileOutputStream);
    }

    @Test
    public void testDownload() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        InputStream src = url.openStream();
        String prefixPath = Constants.PREFIX_PATH;
        File outputFile = new File(prefixPath+"web.html");
        OutputStream dest = new FileOutputStream(outputFile);
        IO.dump(src, dest);
    }

    @Test
    public void testSocket() throws IOException {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9990);
            while (true){
                client = server.accept();
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();
                IO.dump(input,output);
            }
        } catch (Exception e){

        }
    }


}
