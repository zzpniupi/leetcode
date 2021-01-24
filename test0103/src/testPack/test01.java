package testPack;

import java.util.*;

public class test01 {
    public static void main(String[] args){
        int[] A = {3,4,9,5,12,11,10};
        Solution result = new Solution();
        System.out.println(result.VerifySquenceOfBST(A));
    }
}

class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
            return false;
        Stack<Integer> s = new Stack<>();
        int l = pushA.length;
        int n = 0;
        for(int i=0;i<l;i++){
            s.push(pushA[i]);
            while(!s.isEmpty() && s.peek() == popA[n]){
                s.pop();
                n++;
            }
        }
        if(s.isEmpty())    return true;
        else    return false;
    }

    //牛客提供的树节点类
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){            //Collection接口里的方法，没找到在哪实现的
            result.add(queue.peek().val);
            if(queue.peek().left != null)
                queue.add(queue.peek().left);
            if(queue.peek().right != null)
                queue.add(queue.peek().right);
            queue.remove();
        }
        return result;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return isBST(Arrays.copyOfRange(sequence,0,sequence.length));
    }

    public boolean isBST(int[] arr){
        if(arr.length <= 1)
            return true;
        int rootVal = arr[arr.length-1];
        int split = 0;
        while(arr[split] < rootVal)
            split++;
        for(int i=split+1;i<arr.length-1;i++){
            if(arr[i] < rootVal)
                return false;
        }
        return isBST(Arrays.copyOfRange(arr,split,arr.length-1))&&isBST(Arrays.copyOfRange(arr,0,split));
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}