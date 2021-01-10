package leetCode;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        买卖股票的最佳时机 ins = new 买卖股票的最佳时机();
        int[] arr = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};
        System.out.println(ins.maxProfit2(arr));
    }

    //暴力法，两个for循环，时间复杂度为O(n^2)
    public int maxProfit(int[] arr){
        int ret = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                int temp = arr[j] - arr[i];
                if(temp > ret){
                    ret = temp;
                }
            }
        }
        return ret;
    }

    //更新最小值，分区域求出最大收益，一个for循环，时间复杂度为O(n)
    public int maxProfit2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int minPrice = arr[0];
        int maxprofit = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }else{
                int temp = arr[i] - minPrice;
                if(temp > maxprofit){
                    maxprofit = temp;
                }
            }
        }
        return maxprofit;
    }
}
