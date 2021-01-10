package leetCode;

public class 反转单链表 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode pre = null;
        ListNode nex = null;
        while(newHead != null){
            nex = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = nex;
        }
        return pre;
    }
}
