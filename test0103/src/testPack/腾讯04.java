package testPack;

import java.util.Scanner;

//画木板问题
//通过
public class 腾讯04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr));
    }

    public static int fun(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i] - 1;
        }
        res++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        String str = sb.toString();
        String[] strArr = str.split("0");
        for(int i=0;i<strArr.length;i++){
            int[] tempArr = new int[strArr[i].length()];
            for(int j=0;j<strArr[i].length();j++){
                tempArr[j] = Integer.parseInt(strArr[i].charAt(j) + "");
            }
            res += fun(tempArr);
        }
        if(res > arr.length){
            res = arr.length;
        }
        return res;
    }
}
