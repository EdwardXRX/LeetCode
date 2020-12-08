package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: combination_sum_iii_solution
 * @Author: EdwardX
 * @Description: 216
 * @Date: 2020/10/7 21:12
 * @Version: 1.0
 */
public class combination_sum_iii_solution {

    //全局变量：lists。用来存储所有组合
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        //进入递归
        dfs(k, 1, n, list);
        //返回结果集lists
        return lists;
    }

    public static  void dfs(int k, int index, int target, List<Integer> list) {
        //回溯点（递归出口）
        if (target == 0 && k == 0) {
            //保存有效集合至lists集合中
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        //剪枝操作（每次进行判断是否有走下去的必要）
        if (target < index || k <= 0) {
            return;
        }
        //for循环，模拟路径选择器的作用
        for (int i = index; i <= 9; i++) {
            //将当前元素添加至list集合
            list.add(i);
            //递归，深度优先遍历，访问至状态树的叶节点（或解空间）
            dfs(k - 1, i + 1, target - i, list);
            //回溯清理操作
            list.remove(list.size() - 1);
        }
    }

}
