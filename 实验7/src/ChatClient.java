import java.io.IOException;
        import java.net.InetAddress;
        import java.net.Socket;

public class ChatClient {
    public static void main(String []args){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(),6767);
            new Thread(new SendThread(socket),"客户端").start();
            new Thread(new ReserveThread(socket),"客户端").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
