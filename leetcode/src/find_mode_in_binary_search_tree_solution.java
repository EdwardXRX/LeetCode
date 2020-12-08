import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: find_mode_in_binary_search_tree_solution
 * @Author: EdwardX
 * @Description: 501
 * @Date: 2020/9/24 8:25
 * @Version: 1.0
 */

class find_mode_in_binary_search_tree_solution {

    /**
     * preVal :存储上一元素
     * curTimes：当前重复数字个数
     * maxTimes：最大重复数字个数
     */
    int preVal = 0, curTimes = 0, maxTimes = 0;
    //全局变量，动态数组，用来存储我们的结果集
    ArrayList<Integer> list = new ArrayList<Integer>();
    //二叉搜索树中序遍历是递增顺序
    public void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);
            //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
            //如果前后相等，那么说明当前数字重复次数加一
            if (preVal == root.val) {
                curTimes++;
            }
            //否则（不相等）那就让preVal等于当前结点元素值，把curTimes重置为1
            else {
                preVal = root.val;
                curTimes = 1;
            }
            //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
            if (curTimes == maxTimes) {
                list.add(root.val);
                //如果当前数字重复次数大于最大次数
            } else if (curTimes > maxTimes) {
                //回溯操作，清空列表所有元素
                list.clear();
                //将当前元素加入结果数组（更新操作）
                list.add(root.val);
                //最大重复次数等于当前重复次数
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }


    public int[] findMode(TreeNode root) {
        //遍历树操作
        traversal(root);
        //list转换为int[]
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


}


