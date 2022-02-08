package main.java.com.introduction.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class NIOUtil {
    public static void dump(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (src.read(buffer) != -1) {
            buffer.flip();
            dest.write(buffer);
            buffer.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        ReadableByteChannel src = Channels.newChannel(url.openStream());
        WritableByteChannel dest = new FileOutputStream("index.html").getChannel();
        NIOUtil.dump(src, dest);
    }
}
