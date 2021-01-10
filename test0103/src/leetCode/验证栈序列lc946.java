package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class 验证栈序列lc946 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        验证栈序列lc946 ins = new 验证栈序列lc946();

        ins.init(pushed, popped, stack, queue);
    }

    public void init(int[] pushed, int[] popped, Stack<Integer> stack, Queue<Integer> queue){
        for(int i=0; i<popped.length; i++){
            //test git
        }
    }
}
