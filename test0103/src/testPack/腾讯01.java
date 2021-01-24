package testPack;

import java.util.Scanner;

//电话号码问题
//只通过30%
public class 腾讯01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lengthArr = new int[n];
        String[] numberArr = new String[n];
        for(int i=0;i<n;i++){
            lengthArr[i] = sc.nextInt();
            numberArr[i] = sc.next();
        }
        for(String str : numberArr){
            if(str.contains("8")){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
