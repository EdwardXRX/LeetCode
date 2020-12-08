package middle;



import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: binary_tree_postorder_traversal_solution
 * @Author: EdwardX
 * @Description: 145
 * @Date: 2020/10/9 13:35
 * @Version: 1.0
 */
public class binary_tree_postorder_traversal_solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }

    public void postOrder(TreeNode root)
    {
        if(root != null)
        {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
    }

}
