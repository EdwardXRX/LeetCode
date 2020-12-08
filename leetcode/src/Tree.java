/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: Tree
 * @Author: EdwardX
 * @Description: 关于树的一些操作！很实用
 * @Date: 2020/10/9 16:57
 * @Version: 1.0
 */
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode() { }
    }


    // 用数组建立二叉排序树
    public static TreeNode bulidBST(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        for (int i=1; i<A.length; i++) {
            createBST(root, A[i]);
        }
        return root;
    }

    private static void createBST(TreeNode node, int val) {
        if (val<node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else
                createBST(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else
                createBST(node.right, val);
        }
    }

    // 用数组建立普通二叉树
    public static TreeNode buildBinaryTree(TreeNode root, char[] A, int index) {
        if (index>A.length/2)
            return root;
        if (index==0)
            root.val = A[0];
        int left=index*2+1,right=index*2+2;
        if(left<A.length) {
            root.left = new TreeNode(A[left]);
            buildBinaryTree(root.left, A, left);
        }
        if(right<A.length) {
            root.right = new TreeNode(A[right]);
            buildBinaryTree(root.right, A, right);
        }
        return root;
    }


    // 层序遍历打印二叉树
    public static void levelOrderPrintBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null)
            return;
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node==null)
                continue;
            else
                System.out.println(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        levelOrderPrintBST(bulidBST(new int[]{2,1,3,5,7}));
    }
}