package zzpniupi.com;

import java.util.ArrayList;
import java.util.Scanner;

public class jimi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> treeNode = new ArrayList<>();
        while(sc.hasNextInt())
            treeNode.add(sc.nextInt());
        while(!treeNode.isEmpty())
            System.out.println(treeNode.remove(treeNode.size()-1));
    }
}
