package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: binary_tree_preorder_traversal_solution
 * @Author: EdwardX
 * @Description: 144. 二叉树的前序遍历
 * @Date: 2020/10/10 8:43
 * @Version: 1.0
 */
public class binary_tree_preorder_traversal_solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }
    public void preOrder(TreeNode root)
    {
        if(root != null)
        {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
