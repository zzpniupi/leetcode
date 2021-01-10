package usefulCode;

import java.util.Arrays;

public class 排序算法 {
    public static void main(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        Sort sort = new Sort();
        //sort.selectSort(arr);
        sort.quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

class Sort{
    /**
     * 交换数组中的两个数字
     */
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //选择排序
    /** 简单选择排序
     * 每次从数组中选取一个最小的数，与数组第一个数字交换位置。再从剩下的元素中选取最小的元素，与数组第二个元素交换位置，以此类推
     * 时间复杂度为O（n^2）
     * 不稳定的
     */
    public void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = arr[i];
            int minCount = i;
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minCount = j;
                }
            }
            swap(arr,i,minCount);
        }
    }

    /** 堆排序
     *
     */
    public void heapSort(int[] arr){}

    //交换排序
    /** 冒泡排序
     *
     *
     * */
    public void bubbleSort(int arr[]){}

    /** 快排
     *
     * */
    public void quickSort(int arr[],int start,int end){
        int length = end - start + 1;
        if(length <= 1){
            return;
        }
        int flag = arr[start];
        int i = start;
        int j = end;
        while(i != j){
            while(arr[j] >= flag && i != j){
                j--;
            }
            while(arr[i] <= flag && i != j){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,start,i);
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }
}
