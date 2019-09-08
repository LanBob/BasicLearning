package com.lusr.forwin.websocket;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by Lusq
 * Date: 2019/8/31
 * description:
 */
public class WebSocketMain {

    private static WebSocketClient webSocketClient;
    public static void main(String[] args) {
        URI uri = null;
        try {
            uri = new URI("ws://localhost:8080/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        webSocketClient = new WebSocketClient(uri,new Draft_6455()) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("打开链接");
            }

            @Override
            public void onMessage(String s) {
                System.out.println("收到消息");
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("关闭" + s);
            }

            @Override
            public void onError(Exception e) {
                System.out.println("错误");
            }
        };
        webSocketClient.connect();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            send(string.getBytes());
        }
    }

    public static void send(byte[] bytes){
        webSocketClient.send(bytes);
    }
}
