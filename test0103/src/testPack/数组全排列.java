package testPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 数组全排列 {
    public static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {3334,3,3333332};
        fun(arr,new String());
        Collections.sort(list);
        System.out.println("最大的数是： " + list.get(list.size() - 1));
    }

    public static void fun(int[] arr,String str){
        if(arr.length == 1){
            str += arr[0] + "";
            list.add(Long.parseLong(str));
            System.out.println(str);
            return;
        }
        for(int i=0;i<arr.length;i++){
            String newStr = str + arr[i];
            int[] newArr = arrFun(arr,i);
            fun(newArr,newStr);
        }
    }

    public static int[] arrFun(int[] arr,int index){
        int length = arr.length;
        int[] newArr = new int[length - 1];
        int j = 0;
        for(int i=0;i<length;i++){
            if(i == index)
                continue;
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }
}
