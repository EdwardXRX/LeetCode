package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: flatten_binary_tree_to_linked_list_solution
 * @Author: EdwardX
 * @Description: 114. 二叉树展开为链表
 * @Date: 2020/10/11 8:25
 * @Version: 1.0
 */
public class flatten_binary_tree_to_linked_list_solution {
    public void flatten(TreeNode root) {
        pre(root);
    }

    public void pre(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (root.right != null) {
                    back_the_rightest(root.left).right = root.right;
                    root.right = root.left;
                    root.left = null;
                } else {
                    root.right = root.left;
                    root.left = null;
                }
            }
            pre(root.left);
            pre(root.right);
        } else return;

    }

    public TreeNode back_the_rightest(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root;
    }

}
