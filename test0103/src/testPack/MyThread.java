package testPack;

import java.util.HashSet;

public class MyThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTestRunnable());
        t1.run();
        t1.start();
    }
}

class MyTestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
