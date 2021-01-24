package testPack;

import java.util.Scanner;

//粉刷房屋问题
//只能通过30%
public class 腾讯02 {
    public static void main(String[] args) {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                cost[i][j] = sc.nextInt();
            }
        }

        int used = 0;
        int temp = cost[0][0];
        if(cost[0][1] < temp){
            temp = cost[0][1];
            used = 1;
        }
        if(cost[0][2] < temp){
            temp = cost[0][2];
            used = 2;
        }
        total += temp;
        for (int i=1;i<cost.length;i++){
            int zzp = 0;
            int min = cost[i][0];
            if(used == 0){
                min = cost[i][1];
                zzp = 1;
            }else{
                min = cost[i][0];
            }
            for(int j=0;j<3;j++){
                if(j != used && min > cost[i][j]){
                    min = cost[i][j];
                    zzp = j;
                }
            }
            total += min;
            used = zzp;
        }
        System.out.println(total);
    }
}
