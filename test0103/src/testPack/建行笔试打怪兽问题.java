package testPack;

import java.util.Arrays;
import java.util.Scanner;

public class 建行笔试打怪兽问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,hit,t;
        int result = 0;
        n = sc.nextInt();
        hit = sc.nextInt();
        t = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int count = arr[i] / hit;
            int remain = arr[i] - count * hit;
            if(remain != 0){
                count++;
            }
            t -= count;
            if(t < 0){
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}