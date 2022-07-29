package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/13
 */

// 服务端
public class BIOServer {

    public static void main(String[] args) throws Exception {
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建服务端
        ServerSocket serverSocket = new ServerSocket(8089);
        System.out.println("服务端启动成功");
        // 循环接受客户端请求
        while (true) {
            System.out.println("等待客户端连接,阻塞中");
            // 接受客户端请求
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }


    public static void handler(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                System.out.println("等待客户端输入...阻塞中");
                int read = inputStream.read(bytes);
                if (read == -1) {
                    System.out.println("客户端断开连接");
                    break;
                } else {
                    System.out.println("客户端输入了:" + new String(bytes, 0, read));
                }
            }
            inputStream.close();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
