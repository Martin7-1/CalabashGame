package com.nju.edu.server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.List;

/**
 * @author Zyi
 */
public class Server {

    private ServerSocketChannel channel;
    private Selector selector;

    private static final int PORT = 8080;
    private static final String ADDRESS = "localhost";
    private int playerNumber = 2;
    private List<SocketChannel> socketChannels = new ArrayList<>();
    private ByteBuffer buffer;
    private byte[] bytes;

    public Server() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = ByteBuffer.allocate(1024 * 1024);
    }

    private void bind() throws IOException {
        channel = ServerSocketChannel.open();
        // bind server socket channel to port
        // 非阻塞模式的设置必须在设置端口前完成
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(ADDRESS, PORT));
        // 连接selector
        channel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("server is ready, port = " + PORT);
    }

    public void startServer() throws IOException {
        this.bind();
        while (true) {
            // wait for events
            int nReady = selector.select();
            if (nReady == 0) {
                continue;
            }

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (!key.isValid()) {
                    continue;
                }
                if (key.isAcceptable()) {
                    this.accept(key);
                    System.out.println("用户连接成功");
                } else if (key.isReadable()) {
                    bytes = this.read(key);
                } else if (key.isWritable()) {
                    write(key);
                }
            }
            it.remove();
        }
    }

    /**
     * accept from client connection
     * @param key selector key
     * @throws IOException IO异常
     */
    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);
        Socket socket = channel.socket();
        SocketAddress remoteAddr = socket.getRemoteSocketAddress();
        System.out.println("Connected to: " + remoteAddr);
        channel.register(this.selector, SelectionKey.OP_READ);

        this.socketChannels.add(channel);
    }

    /**
     * read from client
     * @param key selector key
     * @throws IOException IO异常
     */
    private byte[] read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        int numRead = -1;
        numRead = channel.read(buffer);

        if (numRead == -1) {
            Socket socket = channel.socket();
            SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            System.out.println("Connection closed by client: " + remoteAddr);
            channel.close();
            key.cancel();
            return null;
        }

        byte[] data = new byte[numRead];
        System.arraycopy(buffer.array(), 0, data, 0, numRead);
        buffer.clear();
        channel.register(selector, SelectionKey.OP_WRITE);

        return data;
    }

    /**
     * write to client
     * maybe not need
     * @param key selector key
     * @throws IOException IO异常
     */
    private void write(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        Socket socket = channel.socket();

        for (SocketChannel socketChannel : socketChannels) {
            buffer.put(bytes);
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        channel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) {
        try {
            new Server().startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
