public class MyException extends  Exception {
    public String message;

    public MyException(String message){
        this.message = message;
    }

    public String toString(){
        return this.message;
    }
}
