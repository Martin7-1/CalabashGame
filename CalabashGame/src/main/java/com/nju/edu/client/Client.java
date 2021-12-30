package com.nju.edu.client;

import com.nju.edu.control.GameController;
import com.nju.edu.screen.GameScreen;
import com.nju.edu.sprite.Calabash;
import com.nju.edu.util.Message;
import com.nju.edu.util.MessageHelper;
import org.apache.commons.lang3.SerializationUtils;

import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author Zyi
 */
public class Client {

    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8080;
    private GameScreen gameScreen;
    private GameController gameController;
    private SocketChannel clientChannel;
    private static int clientID;

    public Client() {
        clientID++;
    }

    private void startClient() throws IOException {
        InetSocketAddress hostAddress = new InetSocketAddress(HOST_NAME, PORT);
        clientChannel = SocketChannel.open(hostAddress);
        clientChannel.configureBlocking(false);

        gameScreen = new GameScreen("Calabash Game", Color.WHITE);
        gameController = new GameController(30, clientID, this);
        gameScreen.add(gameController);
        gameScreen.setVisible(true);
        gameController.setFocusable(true);
        gameController.requestFocus();
        gameController.start();

        System.out.println("Client... started");

        // 发送消息到服务器端
        sendStart();
        while (clientChannel.isConnected()) {
            read();
        }
    }

    /**
     * 告诉服务器新加入了一个客户端
     * @throws IOException IO异常
     */
    private void sendStart() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(MessageHelper.encodeNewClient(gameController));
        buffer.flip();

        if (buffer.hasRemaining()) {
            clientChannel.write(buffer);
        }

        buffer.clear();
    }

    public void send(Message msg) throws IOException {
        // 需要输送到服务器端的消息
        // 包括游戏中的所有物体
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);

        buffer.put(MessageHelper.encode(msg, gameController));
        buffer.flip();

        if (buffer.hasRemaining()) {
            clientChannel.write(buffer);
        }

        buffer.clear();
    }

    private void read() throws IOException {
        // 需要从服务器端读取的数据:
        // 葫芦娃的位置，小怪的位置和子弹的位置
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        int numRead = -1;
        numRead = clientChannel.read(buffer);

        if (numRead == -1 || numRead == 0) {
            return;
        }

        MessageHelper.decode(buffer.array(), gameController);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                new Client().startClient();
                System.out.println(Client.clientID);

                TimeUnit.MILLISECONDS.sleep(200);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
