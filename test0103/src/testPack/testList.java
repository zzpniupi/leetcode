package testPack;

import java.lang.reflect.Array;
import java.util.*;

public class testList {
    public static void main(String[] args){
        List mylist = new ArrayList();
        mylist.add("周");
        mylist.add("子");
        mylist.add("鹏");
        System.out.println(mylist.get(1));

        Set mySet = new HashSet();
        mySet.add("周");
        mySet.add("子");
        mySet.add("鹏");
        System.out.println(mySet.toString());

        Map myMap = new HashMap();
        myMap.put("name","zzp");
        System.out.println(myMap.get("name"));
    }
}
