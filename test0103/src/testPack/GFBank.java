package testPack;

import java.util.Scanner;

public class GFBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(tailOfPower(a,b));
    }

    public static String tailOfPower (int a, int b) {
        // write code here
        int temp = a;
        int num = a;
        for(int i=0;i<b;i++){
            num *= temp;
            num = num % 1000;
        }
        num = num + 10000;
        String str = String.valueOf(num);
        String result = str.substring(str.length() - 3);
        return result;
    }
}
