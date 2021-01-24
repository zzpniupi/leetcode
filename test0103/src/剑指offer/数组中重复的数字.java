package 剑指offer;

import java.util.HashMap;

/*
* 找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
* 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
//这里我理解成了输出所有重复的数字，题目含义是输出重复数字中的一个，简单更改可以实现题目要求

public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        数组中重复的数字 ins = new 数组中重复的数字();
        ins.traverse(nums, map);
        ins.search(map);
        System.out.println("\n" + ins.duplicate(nums));
    }

    public void traverse(int[] nums, HashMap<Integer, Integer> map){
        for(int num : nums){
            if(map.containsKey(num)){
                int temp = map.get(num);
                map.put(num, ++temp);       //注意i++和++i的区别  这里如果用i++的话value的值会一直是1
            }else{
                map.put(num, 1);
            }
        }
    }

    public void search(HashMap<Integer, Integer> map){
        Boolean flag = true;
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                if(flag){
                    flag = !flag;
                    System.out.print(key);
                }
                else
                    System.out.print(" 或 " + key);
            }
        }
    }

    //时间复杂度0（n）空间复杂度O（1）的做法
    //对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
    // 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
    public int duplicate(int[] nums){
        for(int i=0; i<nums.length;i++){
            while(nums[i] != i){
                if(nums[nums[i]] != nums[i])
                    swap(nums, i, nums[i]);
                else
                    return nums[i];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
