package testPack;

public class CircleWait implements Runnable{
    private String value;
    @Override
    public void run() {
        try{
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        value = "I have data now";
    }

    public static void main(String[] args) throws InterruptedException{
        CircleWait cw = new CircleWait();
        Thread t = new Thread(cw);
        t.start();
/*        while(cw.value == null){
                Thread.currentThread().sleep(1000);
            System.out.println(cw.value);
        }*/
        t.join();
        System.out.println(cw.value);
    }
}
