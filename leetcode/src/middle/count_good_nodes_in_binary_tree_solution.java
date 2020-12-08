package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: count_good_nodes_in_binary_tree_solution
 * @Author: EdwardX
 * @Description: 1448. 统计二叉树中好节点的数目
 * @Date: 2020/10/15 10:07
 * @Version: 1.0
 */
public class count_good_nodes_in_binary_tree_solution {

    int temp =0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, new ArrayList<>());
        return temp;
    }
    public void dfs(TreeNode root, ArrayList<Integer> list)
    {
        if(root != null)
        {
            list.add(root.val);
            boolean flag =true;
            //判断是不是‘好节点’
            for(int i : list)
            {
                if(i > root.val)
                {
                    flag = false;
                    break;
                }
            }
            if(flag == true)
            {
                temp++;
            }
            dfs(root.left,list);
            dfs(root.right,list);
            list.remove(list.size() -1);
        }
    }
}
