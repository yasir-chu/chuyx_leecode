package test.nioChatGroup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author yuxiang_chu
 * @date 2023/7/5 17:35
 */
public class Server {

    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT = 9999;

    public Server() {
        try {
            selector = Selector.open();
            ssChannel = ServerSocketChannel.open();
            ssChannel.bind(new InetSocketAddress(PORT));
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {

            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()) {
                        SocketChannel accept = ssChannel.accept();
                        accept.configureBlocking(false);
                        System.out.println(accept.getRemoteAddress() + "上线");
                        accept.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()){
                        readClientData(sk);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readClientData(SelectionKey sk) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) sk.channel();
            // 获取缓存
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int count = socketChannel.read(readBuffer);
            if (count > 0) {
                readBuffer.flip();
                String msg = new String(readBuffer.array(), 0, readBuffer.remaining());
                System.out.println("接收到客户端信息：" + msg);
                sendInfoToOtherClient(msg, socketChannel);
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println(socketChannel.getRemoteAddress() + "离线");
                sk.cancel();
                ssChannel.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void sendInfoToOtherClient(String msg, SocketChannel socketChannel) throws IOException {
        System.out.println("转发信息。。。。");
        for (SelectionKey key : selector.keys()) {
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel && channel != socketChannel) {
                SocketChannel ontherChannel = (SocketChannel) channel;
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                ontherChannel.write(wrap);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }

}
