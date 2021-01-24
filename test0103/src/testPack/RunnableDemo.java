package testPack;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("mr0");
        MyRunnable mr2 = new MyRunnable("mr1");
        MyRunnable mr3 = new MyRunnable("mr2");
        try {
            Thread t = (Thread)Class.forName("java.lang.Thread").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();
    }
}
