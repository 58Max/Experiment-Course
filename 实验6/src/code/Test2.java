package code;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String [] args){

        output("src\\text\\myfile.txt");
        copy("src\\text\\myfile.txt","src\\text\\myfile2.txt");
    }

    public static void output(String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);//创建文件字节输出流对象

            Scanner cin = new Scanner(System.in);

            while(!cin.nextLine().equals("bye")){ //当输入的不为“byte”时一直输入

                byte[] b =cin.nextLine().getBytes();//将输入内容转化并暂存在b数组中

                fileOutputStream.write(b);//将数组写入内存

                fileOutputStream.flush();//将信息从内存刷到硬盘上
            }

            fileOutputStream.close();//关闭文件字节输出流

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String inpath,String outpath){ //inpath 为读取文件 output为写入的文件
        try {
            FileInputStream fileInputStream = new FileInputStream(inpath);//创建输入字节流对象
            FileOutputStream fileOutputStream = new FileOutputStream(outpath);//创建输出字节流对象

            byte []b = new byte[1024]; //创建一个字节数组用来暂存信息

            int len = -1;

            while((len = fileInputStream.read(b)) != -1){//当文件没有读完时

                String str = new String(b,0,len);//把文件内容赋值给字符串

                fileOutputStream.write(str.getBytes());//将字符串转换成字节数组并写到内存中

                fileOutputStream.flush();//将内存中的内容刷到硬盘上
            }

            fileInputStream.close();//关闭输入字节流
            fileOutputStream.close();//关闭输出字节流

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
