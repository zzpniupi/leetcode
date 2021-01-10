package usefulCode;

public class 连续子数组最大的和 {
    public static void main(String[] args) {
        LXSZSolution solution = new LXSZSolution();
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(solution.FindGreatestSumOfSubArray(array));
    }
}

class LXSZSolution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if(len == 0)
            return 0;
        int ret = Integer.MIN_VALUE;
        for(int i=1;i<=len;i++){
            for(int j=0;j+i<=len;j++){
                int temp = 0;
                for(int n=0;n<i;n++){
                    temp += array[j+n];
                }
                if(temp > ret){
                    ret = temp;
                }
            }
        }
        return ret;
    }
}