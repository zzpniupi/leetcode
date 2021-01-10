package leetCode;

public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};
        int[] arr3 = {3,2,3,1,4,5};
        买卖股票的最佳时机2 ins = new 买卖股票的最佳时机2();
        System.out.println(ins.maxProfit(arr3));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int peak = prices[0];
        int valley = prices[0];
        while(i < prices.length-1){
            while(i < prices.length-1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            while(i < prices.length-1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}
