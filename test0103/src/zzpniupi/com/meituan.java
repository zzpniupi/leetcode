package zzpniupi.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class meituan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length, x;
        length = sc.nextInt();
        x = sc.nextInt();
        int[] arr = new int[length];
        for(int i = 0;i < length;i++)
            arr[i] = sc.nextInt();
        int maxCount = find(arr);
        for(int i = 0;i < length;i++){
            int[] testArr = arr;
            for(int j = i;j < length;j++){
                testArr[j] = testArr[j] | x;
                int testCount = find(testArr);
                if(testCount > maxCount)
                    maxCount = testCount;
            }
        }
        System.out.println(maxCount);
    }

    public static int find(int[] arr){
        int count = 0;
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(!myMap.containsKey(arr[i]))
                myMap.put(arr[i],1);
            else{
                int currCount = myMap.get(arr[i]);
                currCount++;
                myMap.put(arr[i],currCount);
                if(currCount > count)
                    count = currCount;
            }
        }
        return count;
    }
}
