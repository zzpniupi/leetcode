package 剑指offer;

public class testMain {
    public static void main(String[] args) {
        CommonFunction cf = new CommonFunction();

        //剑指06
        //构建测试用例
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        ListNode head = node1;
        从尾到头打印链表06 ins = new 从尾到头打印链表06();

        //cf.printArray(ins.reversePrint(head));
        cf.printArray(ins.useStack(head));
    }
}
