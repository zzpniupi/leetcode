package testPack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字节02 {
    public static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String input = sc.next();
            map.put(input,1);
        }
        fun(str,map);
        System.out.println(result);
    }

    public static void fun(String updatedStr,Map<String,Integer> map){
        for(int i=0;i<updatedStr.length();i++){
            String tempStr = updatedStr.substring(0,i+1);
            if(map.containsKey(tempStr)){
                if(i == updatedStr.length() - 1){
                    result++;
                }else{
                    fun(updatedStr.substring(i,updatedStr.length()),map);
                }
            }else{
                continue;
            }
        }
    }
}
