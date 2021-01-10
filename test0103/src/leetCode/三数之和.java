package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * */
public class 三数之和 {
    public static void main(String[] args) {
        三数之和 ins = new 三数之和();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(ins.fun(arr).toString());
    }

/*    //暴力，确定两个数找剩下的一个数
    public static List<List<Integer>> fun1(int[] arr){
        List<List<Integer>>  list = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return list;
        }
        for(int i=0;i<arr.length-2;i++){      //确定第一个数
            for(int j=i+1;j<arr.length-1;j++){      //确定第二个数
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(arr[i]);
                        tempList.add(arr[j]);
                        tempList.add(arr[k]);
                        if(!list.contains(tempList)){
                            list.add(tempList);
                        }
                        break;
                    }
                }
            }
        }
        return list;
    }*/

    public List<List<Integer>> fun2(int[] arr){
        List<MyList> list = new ArrayList<>();
        List<List<Integer>> retList = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return retList;
        }
        for(int i=0;i<arr.length-2;i++){      //确定第一个数
            for(int j=i+1;j<arr.length-1;j++){      //确定第二个数
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        MyList tempList = new MyList();
                        tempList.add(arr[i]);
                        tempList.add(arr[j]);
                        tempList.add(arr[k]);
                        if(!list.contains(tempList)){
                            list.add(tempList);
                        }
                        break;
                    }
                }
            }
        }
        //为了满足题目的返回要求，将List<MyList>转为List<List<Integer>>
        Object[] retArr = list.toArray();
        for(int i=0;i<retArr.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(Object o : (MyList)retArr[i]){
                temp.add((int)o);
            }
            retList.add(temp);
        }
        return retList;
    }

    //类似于两数之和的思想，两个指针
    //标准解答，手动去重
    //当然我还是觉得用重写equals方法去重最方便
    public List<List<Integer>> fun(int[] arr){
        List<List<Integer>> retList = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            if(i != 0 && arr[i] == arr[i-1]){       //第一轮去重，如果key值连续相等，会造成重复的解，则舍弃。原因是排序之后相同的值会紧邻，不会有其他的情况
                continue;
            }
            int key = -arr[i];      //确定剩余的两数之和
            int l = i + 1;      //左指针
            int r = arr.length - 1;     //右指针
            while(l < r){
                if(arr[l] + arr[r] == key){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[l]);
                    list.add(arr[r]);
                    l++;
                    r--;
                    if(l < r && arr[l] == arr[l-1] && arr[r] == arr[r+1]){      //第二轮去重，避免出现[-2,0,0,2,2]这种移动左右指针造成的重复解
                        continue;
                    }
                    retList.add(list);
                }
                else if(arr[l] + arr[r] > key){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return retList;
    }

    class MyList extends ArrayList{
        //重写equals方法，以实现list重复元素的去重；比如[-1, 0, 1]，[0, 1, -1]题目认为为重复元素需要去掉
        @Override
        public boolean equals(Object o) {
            if(this == o){
                return true;
            }
            if(o instanceof MyList){
                MyList mylist = (MyList) o;
                int[] mylistArr = new int[mylist.size()];
                int i = 0;
                for(Object e : mylist){
                    mylistArr[i] = (int)e;
                    i++;
                }
                int[] thislistArr = new int[this.size()];
                int j = 0;
                for(Object e : this){
                    thislistArr[j] = (int)e;
                    j++;
                }
                Arrays.sort(mylistArr);
                Arrays.sort(thislistArr);
                boolean flag = true;
                for(int k=0;k<3;k++){
                    if(mylistArr[k] != thislistArr[k]){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
