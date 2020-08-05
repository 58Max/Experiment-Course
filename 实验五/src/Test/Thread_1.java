package Test;

public class Thread_1 {
    public static void main(String a[])
    {
       Tortoise tortoise = new Tortoise("计算偶数线程",100,100);
       Rabit rabit = new Rabit("计算奇数线程",100,100);

       tortoise.start();
       rabit.start();
    }
}

class Tortoise extends Thread {
    int sleepTime=0;
    int liveLength=0;
    public static  int oddCount = 0;

    public Tortoise(String name,int sleepTime, int liveLength)
    {
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
        super.setName(name);    // 设置线程的名字为name
    }

    public void run()
    {
        while (true) {
            liveLength--;
            countOddNumber(liveLength);

            try{
                    Thread.sleep(sleepTime);    // 让线程调用sleep()方法进入中断状态
                }
            catch (InterruptedException e) {}
            if (liveLength<=0 )
            {
                System.out.println();
                System.out.println(getName()+"进入死亡状态");
                System.out.println("偶数的总个数是： "+oddCount);
                  break;// 结束run()方法的语句
             }
         }
    }

    public void countOddNumber(int length) {
        if(length % 2 != 0 ) {
            oddCount++;
            System.out.print(length+" ");
        }
    }
}
class Rabit extends Thread {
        int sleepTime=0;
        int liveLength=0;
        public static  int evenCount = 0;

        public Rabit(String name,int sleepTime, int liveLength)
        {
            super(name); // 调用父类构造函数，设置线程的名字为name
            this.sleepTime=sleepTime;
            this.liveLength=liveLength;
        }

        public void run() {
              while (true )
            {
                liveLength--;
                countEvenNumber(liveLength);

                try{
                    sleep(sleepTime);
                } catch (InterruptedException e) {}
                 if (liveLength<=0 ) {
                     System.out.println();
                    System.out.println(getName()+"进入死亡状态");
                    System.out.println("奇数的总个数是： "+evenCount);
                    break;
                }

            }
         }

         public void countEvenNumber(int length) {

             if(length % 2 == 0 ) {
                 evenCount++;
                 System.out.print(length+" ");
             }


         }
}
