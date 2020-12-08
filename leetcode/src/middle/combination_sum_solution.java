package middle;

import leetcode.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: combination_sum_solution
 * @Author: EdwardX
 * @Description: 39
 * @Date: 2020/10/8 10:13
 * @Version: 1.0
 */
public class combination_sum_solution {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(lists ,new ArrayList<>(), target, candidates, 0);
        return lists;
    }


    public static void dfs(List<List<Integer>> lists,ArrayList<Integer> list, int target, int[] candidates, int index) {
        if (target < 0)
            return;

        if (target == 0) {
                lists.add(new ArrayList<>(list));
                return;

        }


        for (int i = index; i < candidates.length; i++) {
            if (target < 0)
                break;
            list.add(candidates[i]);
            dfs(lists,list, target - candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }


    }

}
