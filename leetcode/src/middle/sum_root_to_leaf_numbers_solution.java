package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: sum_root_to_leaf_numbers_solution
 * @Author: EdwardX
 * @Description: 129. 求根到叶子节点数字之和
 * @Date: 2020/10/29 8:33
 * @Version: 1.0
 */
public class sum_root_to_leaf_numbers_solution {
    public static void main(String[] args) {


    }


    /*

     1
   /   \
  null  3

  */
    //用来存储所有到叶结点的值
    static List<String> list = new ArrayList<>();


    public static int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        //递归操作
        dfs(root,new StringBuffer());

        int sum= 0;

        for (String str:list) {
            sum+= Integer.parseInt(str);
        }
        return sum;
    }

    //回溯法
    public static void dfs(TreeNode root,StringBuffer str)
    {
        //整个遍历顺序：线序遍历
        if(root!= null)
        {
            //将当前结点的值添加到StringBuffer中
            str.append(root.val);
            //将当前的StringBuffer存储到list中
            if(root.left == null && root.right == null)
            {
                list.add(str.toString());
                return;
            }

            if(root.left != null)
            {
                //先序遍历，遍历左子树
                dfs(root.left,str);
                //回溯
                str.deleteCharAt(str.length()-1);
            }
            if(root.right != null)
            {
                //遍历右子树
                dfs(root.right,str);
                //回溯
                str.deleteCharAt(str.length()-1);
            }


        }
    }
}
