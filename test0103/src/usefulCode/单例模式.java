package usefulCode;

public class 单例模式 {
    public static void main(String[] args) {
        Singleton1.getUniqueInstance();
        Singleton1.doubleCheckGetUniqueInstance();
    }
}

/** 懒汉式，线程不安全
 *  懒汉式是指在要使用对象时才会创建对象，这样可以节约资源
 * */
class Singleton1{
    private static Singleton1 uniqueInstance;
    //private static Singleton1 uniqueInstance = new Singleton1();  线程安全的写法，但是不再是懒汉式

    private Singleton1(){};

    //public static synchronized Singleton1 getUniqueInstance(){   改为同步方法，线程安全的写法，同时保证了懒汉式
    public static Singleton1 getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }

    /** 双重校验锁，保证线程安全，并降低了锁的粒度
     * */
    // private volatile static Singleton1 uniqueInstance;
    // 使用volatile关键字禁止JVM指令重排，多线程情况下uniqueInstance = new Singleton1()
    // 分为三步 1.为uniqueInstance分配内存空间 2.初始化uniqueInstance 3.将uniqueInstance指向分配的内存空间
    // 可能会出现因指令重排uniqueInstance不为空但是却没有初始化
    public static Singleton1 doubleCheckGetUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton1.class){            //只用锁住实例化的部分，但是还是有可能多线程进入if判断中，先后执行实例化语句
                if(uniqueInstance == null){             //所以还需要有一个if判断如果唯一实例已被实例化，用来防止其他线程再次进入同步代码块，执行实例化语句
                    uniqueInstance = new Singleton1();
                }
            }
        }
        return uniqueInstance;
    }
}


