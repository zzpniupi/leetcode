package testPack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//只通过了33.3%
public class 字节04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int type = sc.nextInt();
            switch (type){
                case 1:
                    int pos = sc.nextInt();
                    String update = sc.next();
                    char[] arr = str.toCharArray();
                    arr[pos - 1] = update.charAt(0);
                    str = Arrays.toString(arr);
                    break;
                case 2:
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    String temp = str.substring(l - 1,r);
                    char[] arr2 = temp.toCharArray();
                    Map<Character,Integer> map = new HashMap<>();
                    for(char c : arr2){
                        if(!map.containsKey(c)){
                            map.put(c,1);
                        }
                    }
                    System.out.println(map.size());
                    break;
            }
        }
    }
}
