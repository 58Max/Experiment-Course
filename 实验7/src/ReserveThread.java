import java.io.*;
import java.net.Socket;

public class ReserveThread implements Runnable {
    private Socket socket;
    private DataInputStream in = null;
    private String msg = null;
    public ReserveThread(Socket socket){
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Reserve(){
        while(true){
            try {
                msg = in.readUTF();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
       Reserve();
    }
}
