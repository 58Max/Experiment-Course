public class ExceptionTest {
    public static void main(String [] args){
        int i=0;
        String greeting[] = {"Hello", "Only", "Test"};
        while(i<4){
            try{
                System.out.println(greeting[4]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("数组越界");
            }finally {
                System.out.println("总会执行");
            }
            i++;
        }
    }
}
