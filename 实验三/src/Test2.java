import java.util.Scanner;

public class Test2 {
    public static void main(String []args){
        Scanner cin = new Scanner(System.in);

        String input = cin.nextLine();
        while(!input.equals("XYZ")&&!input.equals("ABC")){
            System.out.println("请重新输入：");
            input = cin.nextLine();
        }

       try{new TestScanner(input).input();}
       catch (MyException e){
           System.out.println(e.toString());
       }

    }
}
