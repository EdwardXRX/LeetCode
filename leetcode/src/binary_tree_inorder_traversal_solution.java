import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: binary_tree_inorder_traversal_solution
 * @Author: EdwardX
 * @Description: 94
 * @Date: 2020/9/30 11:13
 * @Version: 1.0
 */
public class binary_tree_inorder_traversal_solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null)
        {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
