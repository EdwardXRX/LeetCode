package middle;

import java.util.ArrayList;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: count_good_nodes_in_binary_tree_solution_2
 * @Author: EdwardX
 * @Description: 1448. 统计二叉树中好节点的数目_方法二
 * @Date: 2020/10/15 10:45
 * @Version: 1.0
 */
public class count_good_nodes_in_binary_tree_solution_2 {

    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> list_leaves = new ArrayList<Integer>();
    int temp =0;

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        //当前情况下，list存入的是所有结点的val
        //list_leaves存的是list中叶结点的下标。
        dfs(root);
        //System.out.println(list_leaves.get(0));

        for (int i = 0; i < list_leaves.size(); i++) {
            
        }


        int num = 0;
        return num;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            if(root.left == null && root.right ==null)
            {
                list_leaves.add(temp);
            }
            temp++;
            dfs(root.left);
            dfs(root.right);
        }
    }

}
