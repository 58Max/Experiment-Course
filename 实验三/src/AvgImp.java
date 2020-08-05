import java.util.Arrays;
import java.util.*;

public class AvgImp implements Average {

    //求平均值的函数
    @Override
    public double getAverage1(Student[] students) {

        double allResult = 0;//求分数总和

        //遍历Student对象数组，获得分数属性并相加
        for(Student  student : students){
            allResult += student.getScore();
        }

        //求平均值
        double avg = allResult/students.length;

        return avg;
    }

    @Override
    public double getAverage2(Student[] students) {

        //利用Comparator接口实现对数组的排序
        Comparator up = new Comparator<Student>(){
            //实现方法
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() >= o2.getScore()){
                    return -1;
                }
                else
                 return 0;
            }
        };

        //对Student对象数组进行排序
        Arrays.sort(students,up);

        double allResult = 0;

        for(int i = 1;i < students.length-1; i++){
            allResult += students[i].getScore();
        }

        return allResult / (students.length-2);
    }
}
