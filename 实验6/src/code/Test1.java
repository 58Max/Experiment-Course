package code;

import java.io.*;

public class Test1 {
    public static void main(String []args){
        File fileone = new File("src\\text\\hello.txt");
        File filetwo = new File("src\\text\\hello.secret");

        char b[] = new char[100];
        try {
            FileReader in = new FileReader(fileone);
            FileWriter out = new FileWriter(filetwo);

            int n = -1;

            while((n = in.read(b)) != -1){
                for(int i = 0;i < n;i++){
                    b[i] = (char)(b[i]^'a');
                }

                out.write(b);
                out.flush();
            }

            out.close();

            in = new FileReader(filetwo);

            System.out.println("加密后的文件内容：");

            n = in.read(b);

            while(n != -1){
                String str = new String(b,0,n);
                System.out.println("dfjakfjd"+str);
                n = in.read(b);
            }

            in = new FileReader(filetwo);

            System.out.println("解密后的文件内容：");

            while((n = in.read(b)) != -1){
                for(int i = 0;i < n;i++){
                    b[i] = (char)(b[i]^'a');
                    String str = new String(b,0,n);
                    System.out.println(str);
                }
            }

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
