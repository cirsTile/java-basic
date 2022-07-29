package demo;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/13
 */

public class BIOClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8089);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("bye".equals(line)) {
                break;
            }
            outputStream.write(line.getBytes());
            outputStream.flush();
        }
        outputStream.close();
        socket.close();
    }
}
