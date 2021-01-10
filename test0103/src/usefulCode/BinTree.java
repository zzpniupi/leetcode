package usefulCode;

import java.util.*;

/*
* BinTree类实现了二叉树根据前序遍历顺序输入建立，以及前序，中序，后序，层次遍历
*                       1
*                    /     \
*                   2        7
*                /    \     /  \
*               3      5   8    9
*                \    /        /  \
*                 4  6        10   11
* 测试数据：
* 1 2 3 # 4 # # 5 6 # # # 7 8 # # 9 10 # # 11 # #  （说明：其中#说明左右子树为空）
* 用先序遍历来建立树,再依次输出前序，中序，后序，层次遍历结果
* */
public class BinTree {
    public static void main(String[] args) {
        BinTreeFunction btf = new BinTreeFunction();
        TreeNode root = null;
        root = btf.buildTree(root);
        System.out.println(btf.preOrder(root).toString());
        System.out.println(btf.inOrder(root).toString());
        System.out.println(btf.postOrder(root).toString());
        System.out.println(btf.levelOrder(root).toString());
    }
}

class BinTreeFunction{
    Scanner sc = new Scanner(System.in);

    /*
     * 此方法用来以前序遍历顺序输入节点值创建二叉树，参数root用来最后返回根节点
     * 调用示例
     * TreeNode root = null;
     * root = buildTree(root);
     * 创建过程为按照前序遍历顺序逐个输入节点值，
     * 如：1 2 3 # 4 # # 5 6 # # # 7 8 # # 9 10 # # 11 # #  （说明：其中#说明左右子树为空）
     * */
    public TreeNode buildTree(TreeNode root){
        String val = sc.next();
        if(val.equals("#"))
            return null;
        root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(root.left);
        root.right = buildTree(root.right);
        return root;
    }

    /*
    * 前序遍历二叉树
    * 参数：二叉树根节点
    * 返回值：ArrayList<Integer>类型的数组
    * */
    public ArrayList<Integer> preOrderResult = new ArrayList<>();
    public ArrayList<Integer> preOrder(TreeNode root){
        if(root == null)
            return null;
        preOrderResult.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return preOrderResult;
    }

    /*
     * 中序遍历二叉树
     * 参数：二叉树根节点
     * 返回值：ArrayList<Integer>类型的数组
     * */
    public ArrayList<Integer> inOrderResult = new ArrayList<>();
    public ArrayList<Integer> inOrder(TreeNode root){
        if(root == null)
            return null;
        inOrder(root.left);
        inOrderResult.add(root.val);
        inOrder(root.right);
        return inOrderResult;
    }

    /*
     * 后序遍历二叉树
     * 参数：二叉树根节点
     * 返回值：ArrayList<Integer>类型的数组
     * */
    public ArrayList<Integer> postOrderResult = new ArrayList<>();
    public ArrayList<Integer> postOrder(TreeNode root){
        if(root == null)
            return null;
        postOrder(root.left);
        postOrder(root.right);
        postOrderResult.add(root.val);
        return postOrderResult;
    }

    /*
    * 层次遍历二叉树
    * 思想：利用一个队列辅助逐个遍历每行节点
    * */
    public ArrayList<Integer> levelOrderResult = new ArrayList<>();
    public ArrayList<Integer> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            levelOrderResult.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return levelOrderResult;
    }
}

//牛客网提供的简单节点类
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}