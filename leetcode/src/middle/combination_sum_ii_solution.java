package middle;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: combination_sum_ii_solution
 * @Author: EdwardX
 * @Description: 40
 * @Date: 2020/9/25 8:35
 * @Version: 1.0
 */
public class combination_sum_ii_solution {

    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {

        ArrayList<Integer> list = new ArrayList<>();

        if (candidates.length == 0 || candidates == null)
            return lists;
        Arrays.sort(candidates);

        dfs(0, list, target, candidates);

        return lists;


    }


    public static void dfs(int index, ArrayList<Integer> list, int sum, int[] candidates) {

        if (sum < 0)
            return;
        if (sum == 0) {
            if (!lists.contains(list)) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i + 1, list, sum - candidates[i], candidates);
            list.remove(list.size() - 1 );

        }


    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 4, 5, 6, 7};
        int target = 10;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = combinationSum2(candidates, target);
        for (List<Integer> x : result) {
            for (int i : x) {
                System.out.print(i);
            }
            System.out.println("");
        }


    }


}
