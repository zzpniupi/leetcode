package leetCode;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        搜索旋转排序数组 ins = new 搜索旋转排序数组();
        int start = ins.findIndexOfSwitchPoint(nums);

    }

    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = left + ((right - left) >> 1);     //>>指二进制数向右移动一位， 即将数字/2， 但是这样做二进制运算效率更高
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findIndexOfSwitchPoint(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
