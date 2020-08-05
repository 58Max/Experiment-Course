public class CanNotToNumberException extends  Exception {
    private String message;

    public CanNotToNumberException(String message){
        this.message = message;
    }

    public String toString(){
        return this.message;
    }
}
