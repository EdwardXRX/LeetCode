package middle;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Arrays;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: maximum_binary_tree_solution
 * @Author: EdwardX
 * @Description: 654. 最大二叉树
 * @Date: 2020/10/20 9:00
 * @Version: 1.0
 */


/*
* 输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1

*/
public class maximum_binary_tree_solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode head = constructMaximumBinaryTree(nums);
        print_tree(head);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }


    //二分法
    public static TreeNode dfs(int[] nums, int start, int end) {
        //递归出口
        if (start > end) {
            return null;
        }

        //递归体
        int index = start;
        //通过for循环获得当前数组的最大值的下标
        for (int i = start; i <= end; i++) {
            if (nums[i] >= nums[index])
                index = i;
        }

        //建立结点
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = dfs(nums, start, index - 1);
        treeNode.right = dfs(nums, index + 1, end);
        return treeNode;
    }


    public static void print_tree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            print_tree(root.left);
            print_tree(root.right);
        }
    }
}
