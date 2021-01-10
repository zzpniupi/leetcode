package usefulCode;

public class 两线程交替打印 {
    public static void main(String[] args) {
        Object object = new Object();
        shuzi sz = new shuzi(object);
        zimu zm = new zimu(object);
        sz.start();
        zm.start();
    }
}

class shuzi extends Thread{
    private Object object;

    public shuzi(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for(int i=1;i<=52;i++){
                System.out.print(i);
                if(i % 2 == 0){
                    try{
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        }
    }
}

class zimu extends Thread{
    private Object object;

    public zimu(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for(int i=0;i<26;i++){
                System.out.print((char)(i + 'A') + " ");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
