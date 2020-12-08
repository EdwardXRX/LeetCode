package middle;

import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: binary_search_tree_iterator_solution
 * @Author: EdwardX
 * @Description: 173. 二叉搜索树迭代器
 * @Date: 2020/10/10 9:02
 * @Version: 1.0
 */
public class binary_search_tree_iterator_solution {

    Stack<Integer> stack = new Stack<>();
    private void dfs(TreeNode root)
    {
        if(root != null)
        {
            dfs(root.right);
            stack.push(Integer.valueOf(root.val));
            dfs(root.left);
        }
    }
    public binary_search_tree_iterator_solution(TreeNode root) {
            dfs(root);
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.isEmpty() == false)
            return stack.pop();

        return -1;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}
