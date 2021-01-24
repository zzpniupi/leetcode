package testPack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock{
    public static void main(String[] args) {
        myLock r = new myLock();
        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        t1.start();
        t2.start();
    }
}

class myLock implements Runnable{
    Lock lock = new ReentrantLock();

    public void run(){
        //测试lock()
/*        lock.lock();
        try{
            System.out.println("线程 " + Thread.currentThread().getName() + "获得了锁");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("线程 " + Thread.currentThread().getName() + "释放了锁");
            lock.unlock();L
        }*/

        //测试tryock()
        if(lock.tryLock()){
            try{
                System.out.println("线程 " + Thread.currentThread().getName() + "获得了锁");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("线程 " + Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("锁被占用，线程 " + Thread.currentThread().getName() + "无法获取锁");
        }
    }
}
