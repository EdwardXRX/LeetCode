/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: invert_binary_tree_solution
 * @Author: EdwardX
 * @Description: 226. 翻转二叉树
 * @Date: 2020/10/15 9:40
 * @Version: 1.0
 */
public class invert_binary_tree_solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        if((root.left != null && root.right != null) ||(root.left == null && root.right != null) ||(root.left != null && root.right == null))
        {
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right =temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
