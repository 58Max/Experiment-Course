import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
        public static void main(String[] args){
        int num = 0 ;
        String password = "58max00233";
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            String msg = null;
            serverSocket = new ServerSocket(8578);
            socket = serverSocket.accept();
            System.out.println("客户端已连接");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
                out.writeUTF("verifying Server");
                out.flush();

                while (true) {
                    num += 1;
                    if(num == 4){
                        out.writeUTF("Illegal User");
                        out.flush();
                        Thread.sleep(10000);
                        break;
                    }
                    System.out.println(num);
                    msg = in.readUTF();
                    System.out.println(msg);
                    if (!password.equals(msg)) {
                            out.writeUTF("PassWord Wrong!");
                            out.flush();
                    } else {
                        out.writeUTF("ORegistration Successful!");
                        out.flush();
                        break;
                    }

                }

                in.close();
                out.close();
                socket.close();
                serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}