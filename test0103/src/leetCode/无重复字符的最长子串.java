package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        无重复字符的最长子串 obj = new 无重复字符的最长子串();
        System.out.println(obj.slidingWindow(str));
    }

    //暴力遍历
    public int baoli(String str){
        if(str == null || str.equals(""))
            return 0;
        char[] charArr = str.toCharArray();
        int result = 1;
        for(int i=0;i<charArr.length-1;i++){
            int tempResult = 1;
            LinkedList<Character> list = new LinkedList<>();
            list.add(charArr[i]);
            for(int j=i+1;j<charArr.length;j++){
                if(!list.contains(charArr[j])){
                    list.add(charArr[j]);
                    tempResult++;
                }else{
                    break;
                }
            }
            if(tempResult > result){
                result = tempResult;
            }
        }
        return result;
    }

    //滑动窗口
    public int slidingWindow(String str){
        if(str == null || str.equals(""))
            return 0;
        char[] charArr = str.toCharArray();
        int result = 1;
        ArrayList<Character> list = new ArrayList<>();
        list.add(charArr[0]);
        for(int i=1;i<charArr.length;i++){
            if(!list.contains(charArr[i])){
                list.add(charArr[i]);
            }else{
                int index = list.indexOf(charArr[i]);
                for(int j=0;j<=index;j++){
                    list.remove(0);
                }
                list.add(charArr[i]);
            }
            if(result < list.size()){
                result = list.size();
            }
        }
        return result;
    }
}
