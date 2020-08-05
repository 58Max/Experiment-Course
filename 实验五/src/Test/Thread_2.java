package Test;

public class Thread_2 {
    public static void main(String [] args){
        __thread __thread1 = new __thread(new Person("赵",20,1));
        __thread __thread2 = new __thread(new Person("钱",10,1));
        __thread __thread3 = new __thread(new Person("孙",20,2));
        __thread __thread4 = new __thread(new Person("李",10,2));
        __thread __thread5 = new __thread(new Person("周",5,1));

        Thread thread1 = new Thread(__thread1);
        Thread thread2 = new Thread(__thread2);
        Thread thread3 = new Thread(__thread3);
        Thread thread4 = new Thread(__thread4);
        Thread thread5 = new Thread(__thread5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
class Person {
    public String name;
    public int money;
    public int number;
    public static int fiveYuan = 1;

    public Person(String name, int money, int number){
        this.name = name;
        this. money = money;
        this.number = number;
    }

    public  void buytickets() {
        synchronized(this){
        if(this.money==20 && this.number == 1){

            System.out.println(this.name+"先生");
            if(fiveYuan >= 1){
                fiveYuan-=1;
                System.out.println("找零给您1张10元，1张5元");
                System.out.println("购买成功！");
            }
            else
                System.out.println("购买失败！");
        }

        else if(this.money == 10 && this.number ==1) {
            System.out.println(this.name + "先生");
            if (fiveYuan >= 1) {
                fiveYuan -= 1;
                System.out.println("找零您1张5元");
                System.out.println("购买成功！");
            } else
                System.out.println("购买失败！");
        }

        else if(this.money == 10 && this.number ==2){
            System.out.println(this.name+"先生");
            System.out.println("购买成功！");
        }
        else if(this.money == 20 && this.number == 2){
            System.out.println(this.name+"先生");
            System.out.println("找零您1张10元");
            System.out.println("购买成功！");
        }
        else if(this.money == 5 && this.number == 1){
            System.out.println(this.name+"先生");
            System.out.println("购买成功！");
            }
        }
    }
}
class __thread implements Runnable{
    Person person;
    public __thread(Person person){
        this.person = person;
    }
    @Override
    public void run() {
        person.buytickets();
    }
}
