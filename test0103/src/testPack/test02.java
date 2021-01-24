package testPack;

import leetCode.ListNode;

public class test02 {
    public ListNode reverse(ListNode root){
        ListNode pre = null;
        ListNode nex = null;
        ListNode temp = root;
        while(temp != null){
            nex = temp.next;
            temp.next = pre;
            pre = temp;
            temp = nex;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

