package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: count_complete_tree_nodes_solution
 * @Author: EdwardX
 * @Description: 222. 完全二叉树的节点个数
 * @Date: 2020/10/12 8:57
 * @Version: 1.0
 */
public class count_complete_tree_nodes_solution {
    int temp =0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return temp;
    }
    public void dfs(TreeNode root)
    {
        if(root != null)
        {
            temp++;
            dfs(root.left);
            dfs(root.right);
        }
    }
}
