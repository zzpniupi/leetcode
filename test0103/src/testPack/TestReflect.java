package testPack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//使用反射获取类的私有方法
public class TestReflect {
/*    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("testPack.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is "+rc.getName());
        r.puSayHi("通过实例调用public方法");
        Method getPrSayHi = rc.getDeclaredMethod("prSayHi", String.class);       //通过getDeclaredMethod获取私有方法；
                                                                                        // getDeclaredMethod可以获取除继承自父类的或实现于接口的所有方法
        getPrSayHi.setAccessible(true);     //私有方法，必须先设置Accessible为true
        getPrSayHi.invoke(r,"通过反射获取的私有方法");
        Method getPuSayHi = rc.getMethod("puSayHi", String.class);      //通过getMethod获取共有方法；
                                                                               //getMethod可以获取除私有方法之外的所有方法
        getPuSayHi.invoke(r,"通过反射获取的公有方法");
        Field getName = rc.getDeclaredField("name");
        getName.setAccessible(true);
        getName.set(r,"zzp");
        getPuSayHi.invoke(r,"通过反射获取的公有方法");
    }*/
}


