package test.nioChatGroup;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yuxiang_chu
 * @date 2023/7/5 17:48
 */
public class Client1 {

    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;
    private static final String ip = "127.0.0.1";
    private static final int port = 9999;

    public Client1(){
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
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
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
        Client1 client1 = new Client1();
        new Thread(() -> {
            client1.readInfo();
        }).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            client1.sendToServer(s);
        }
    }
}
