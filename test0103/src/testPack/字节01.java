package testPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//只通过了66.6%
public class 字节01 {
    public static void main(String[] args) {
        String str = "";
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int type = sc.nextInt();
            switch (type){
                case 1:
                    String temp = sc.next();
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(temp);
                    str = sb.toString();
                    list.add(str);
                    break;
                case 2:
                    int kDelete = sc.nextInt();
                    str = str.substring(0,str.length() - kDelete);
                    list.add(str);
                    break;
                case 3:
                    int kOut = sc.nextInt();
                    System.out.println(str.charAt(kOut - 1));
                    break;
                case 4:
                    str = list.get(list.size() - 2);
                    list.remove(list.size() - 1);
                    break;
            }
        }
    }
}
