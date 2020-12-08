package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: binary_tree_pruning_solution
 * @Author: EdwardX
 * @Description: 814
 * @Date: 2020/10/9 16:13
 * @Version: 1.0
 */
public class binary_tree_pruning_solution {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        else {
            TreeNode T = root;
            preFind(root);
            return T;
        }
    }


    //
    public void preFind(TreeNode root) {
        if (root != null) {

            //如果左孩子不空
            if (root.left != null) {
                //判断是不是叶节点
                if (root.left.left == null && root.left.right == null && root.left.val == 0)
                    root.left = null;
                preFind(root.left);

            }

            if (root.right != null) {
                if (root.right.left == null && root.right.right == null && root.right.val == 0)
                    root.right = null;
                preFind(root.right);
            }


        }
        else
            return;
    }
    //打印二叉树
    public static void printTree(TreeNode root)
    {
        if(root != null)
        {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
