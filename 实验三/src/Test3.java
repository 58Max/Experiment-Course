import java.util.Scanner;

public class Test3 {
    public static void main(String []args){
        Student[] students = new Student[4];

        Scanner cin = new Scanner(System.in);

        for(int i = 0;i < 4;i++){
            students[i] = new Student();

            double score = cin.nextDouble();

            students[i].setScore(score);
        }

        System.out.println(new AvgImp().getAverage1(students));

        System.out.println(new AvgImp().getAverage2(students));

    }
}