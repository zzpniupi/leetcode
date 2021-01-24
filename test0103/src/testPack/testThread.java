package testPack;

public class testThread {
    public static void main(String[] args) {
        Runnable runnable = new RunnableTest();
        Runnable nr = new Runnable() {
            @Override
            public void run() {
                int a = 0;
                while(a < 20){
                    System.out.println(Thread.currentThread().getName() + a);
                    a++;
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

class RunnableTest implements Runnable{
    int a = 100;    //share data
    Object obj = new Object();
    @Override
    public void run() {
        synchronized (obj){
            while(a > 0){
                System.out.println(Thread.currentThread().getName() + "=" + a);
                a--;
            }
        }
    }
}