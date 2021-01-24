package 剑指offer;

import java.util.LinkedList;
import java.util.Stack;

public class 从尾到头打印链表06 {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(head != null){
            head = head.next;
            length ++;
        }
        int[] res = new int[length];
        traverse(temp, res, length);
        return res;
    }

    public void traverse(ListNode head, int[] array, int i){        //i指代数组长度
        if(head == null)    return;
        i --;
        traverse(head.next, array, i);
        array[i] = head.val;
    }

    public int[] useStack(ListNode head){
        //leetcode不建议使用Stack，建议使用LinkedList替代Stack
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i=0; i<res.length; i++){
            res[i] = stack.removeLast();
        }
        return res;
    }
}
