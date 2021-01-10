package usefulCode;

import java.util.*;

public class 最小的K个数 {
    public static void main(String[] args) {
        ZXKSolution solu = new ZXKSolution();
        int[] input = {4,5,1,6,2,7,3,8};
        String str = solu.GetLeastNumbers_Solution(input,10).toString();
        System.out.println(str);
    }
}

class ZXKSolution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length<k)
            return list;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}