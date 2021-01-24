package zzpniupi.com;

import java.util.*;

public class BaiduGuozhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int renshu = sc.nextInt();
        int gzzhonglei = sc.nextInt();
        Map<Integer,Integer> myMap = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < renshu ; i++){
            int favor = sc.nextInt();
            if(!myMap.containsKey(favor))
                myMap.put(favor,1);
            else{
                int currCount = myMap.get(favor);
                currCount++;
                myMap.put(favor,currCount);
            }
        }
        for(Map.Entry<Integer,Integer> entry : myMap.entrySet()){
            int currCount = entry.getValue();
            int temp = (currCount+1)/2;
            count += temp;
        }
        List<Integer> list = new ArrayList<>();
        Iterator iterator = list.iterator();
        System.out.println(count);
    }
}
