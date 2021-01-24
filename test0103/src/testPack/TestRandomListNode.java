package testPack;

public class TestRandomListNode {
    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n3;
        n2.random = n4;
        n3.random = n1;
        n4.random = n2;
        RLNSolution test = new RLNSolution();
        test.Clone(n1);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class RLNSolution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        //在每个节点之间插入新节点，并更新next指针
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode curr = pHead;
        while(curr != null){
            RandomListNode tempNode = new RandomListNode(curr.label);
            if(curr == pHead){
                tempNode = newHead;
            }
            tempNode.next = curr.next;
            curr.next = tempNode;
            curr = tempNode.next;
        }
        //更新新增节点的random指针
        curr = pHead;
        RandomListNode newCurr = newHead;
        while(curr != null){
            newCurr.random = curr.random.next;
            if(newCurr.next == null)
                break;
            curr = curr.next.next;
            newCurr = newCurr.next.next;
        }
        //将新链表拆出来
        newCurr = newHead;
        while(newCurr.next != null){
            newCurr.next = newCurr.next.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
