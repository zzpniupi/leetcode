package usefulCode;
import java.util.Arrays;
import java.util.Scanner;

public class IO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] arr = sc.nextLine().split(",");
            Arrays.sort(arr);
            for(int i = 0;i < arr.length;i++){
                if(i != arr.length - 1){
                    System.out.print(arr[i] + ",");
                }else{
                    System.out.println(arr[i]);
                }
            }
        }
    }
}