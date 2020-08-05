

public class TestScanner {
    public String input;

    public TestScanner(String input){
        this.input = input;
    }

    public void input() throws MyException{
        if (this.input.equals("XYZ")){
            throw new MyException("This is a XYZ");
        }
    }
}
