import java.util.Scanner;

public class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String s ){
        super(s);
    }

}
class  Test{
    public static void main(String [] args){
        A a = new A();
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        try{
            a.setMessage(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
class  A{
    public  void setMessage(String str)throws MyException{
        if(str.equals("XYZ"))
            throw  new MyException("This is XYZ");
    }
}
