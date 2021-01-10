package usefulCode;

import java.util.Arrays;

public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {2,3,7,5,10,9,4,1,6,8};
        System.out.println(binarySearch(arr,7));
    }

    public static int binarySearch(int[] arr,int key){
        Arrays.sort(arr);
        int l = 0;
        int h = arr.length - 1;
        while(l != h){
            int m = (h + l) / 2;        //找中间点
            if(arr[m] > key){
                h = m - 1;
            }else if(arr[m] < key){
                l = m + 1;
            }else{
                return 1;
            }
        }
        if(arr[l] == key){
            return 1;
        }
        return -1;
    }
}
