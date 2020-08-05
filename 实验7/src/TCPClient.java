import java.io.*;
import java.net.InetAddress;
import java.net.Socket;



public class TCPClient {

    public static void main(String []args){
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        BufferedReader br = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(),8578);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));


                String msg = in.readUTF();
                System.out.println(msg);
                //向服务端输入密码
                String password = null;
                password = br.readLine();
                out.writeUTF(password);
                out.flush();
                //输出来自客户端的信息
                msg = in.readUTF();
                //当输入密码不正确时
                while (msg.equals("PassWord Wrong!") || msg.equals("Illegal User")) {
                    if (msg.equals("Illegal User")) {
                        break;
                    }
                    System.out.println(msg);
                    password = br.readLine();
                    out.writeUTF(password);
                    out.flush();
                    msg = in.readUTF();
                }
                System.out.print(msg);
                out.close();
                in.close();
                socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
