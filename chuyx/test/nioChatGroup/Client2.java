package test.nioChatGroup;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yuxiang_chu
 * @date 2023/7/5 18:29
 */
public class Client2 {

    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;
    private static final String ip = "127.0.0.1";
    private static final int port = 9999;

    public Client2(){
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, port));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            userName = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println("当前客户端完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readInfo() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.keys().iterator();
                if (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                        channel.read(byteBuffer);
                        System.out.println(new String(byteBuffer.array()).trim());
                    }
                    iterator.remove();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToServer(String s) {
        s = userName +"说："+s;
        try {
            socketChannel.write(ByteBuffer.wrap(s.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client2 client2 = new Client2();
        new Thread(() -> {
            client2.readInfo();
        }).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            client2.sendToServer(s);
        }
    }
}
