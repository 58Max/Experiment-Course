import java.io.*;
import java.net.Socket;

public class SendThread implements Runnable{
    private Socket socket;
    private DataOutputStream out = null;
    private BufferedReader br = null;
    private String msg = null;
    public SendThread(Socket socket){
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendmsg(){
        while(true){
            try {
                msg = br.readLine();
                out.writeUTF(msg);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        sendmsg();
    }
}
