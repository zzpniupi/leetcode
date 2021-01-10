package usefulCode;

import java.util.*;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 *
 */

public class 字符串的排列 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Permutation("abc");
    }
}

class Solution {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] arr = str.toCharArray();
        fun(arr,arr.length,0);
        Collections.sort(list);
        for(String res : list){
            System.out.println(res);
        }
        return list;
    }

    //arr重新排序后的字符数组
    //len数组长度，start递归开始点
    public void fun(char[] arr,int len,int start){
        if(len-start == 1){
            String str = new String(arr);
            if(!list.contains(str)){
                list.add(str);
            }
            return;
        }
        for(int i=start;i<len;i++){
            swap(arr,start,i);
            fun(arr,len,start+1);
            swap(arr,start,i);
        }
    }

    public void swap(char[] arr,int x,int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}