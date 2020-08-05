import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String []args){
        try {
            ServerSocket serverSocket = new ServerSocket(6767);
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接！----------------");
            new Thread(new SendThread(socket),"服务端").start();
            new Thread(new ReserveThread(socket),"服务端").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
