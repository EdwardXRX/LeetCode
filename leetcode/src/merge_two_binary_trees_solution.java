import sun.reflect.generics.tree.Tree;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: merge_two_binary_trees_solution
 * @Author: EdwardX
 * @Description: 617
 * @Date: 2020/9/23 19:05
 * @Version: 1.0
 */
public class merge_two_binary_trees_solution {
    public static void main(String[] args) {

    }

    public static void traverse(TreeNode t1, TreeNode t2,TreeNode t3) {

        if (t1 != null && t2 != null) {
            t3.val = (t1.val + t2.val);
        }else if(t1 == null && t2!=null)
            t3.val = (t1.val+t2.val);
        else if (t1 != null && t2 == null)
            t3.val = t1.val;
        else t3 = null;

        traverse(t1.left,t2.left,t3.left);
        traverse(t1.right,t2.right,t3.right);

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t3 = null;
        traverse(t1, t2, t3);
        return t3;
    }
}
