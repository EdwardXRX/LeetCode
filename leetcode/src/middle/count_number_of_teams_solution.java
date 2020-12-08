package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: count_number_of_teams_solution
 * @Author: EdwardX
 * @Description: 1395. 统计作战单位数
 * @Date: 2020/10/16 10:48
 * @Version: 1.0
 */
public class count_number_of_teams_solution {
    List<int[]> lists_min = new ArrayList<>();
    List<int[]> lists_max = new ArrayList<>();

    public int numTeams(int[] rating) {
        int[] max = new int[3];
        max[0] = 10001;
        max[1] = 10001;
        max[2] = 10001;

        min_dfs(rating,3,new int[3]);
        max_dfs(rating,3,max);

        return lists_min.size() + lists_max.size();
    }

    public void min_dfs(int[] rating, int k, int[] list) {
        if (k == 0) {
            lists_min.add(list);
        }
        for (int i = 0; i < rating.length; i++) {
            if (rating[i] > list[0] && rating[i] > list[1] && rating[i] > list[2]) {
                list[k - 1] = rating[i];
                min_dfs(rating, k - 1, list);
                list[k - 1] = 0;
            }
        }
    }

    public void max_dfs(int[] rating, int k, int[] list) {
        if (k == 0) {
            lists_max.add(list);
        }
        for (int i = 0; i < rating.length; i++) {
            if (rating[i] < list[0] && rating[i] < list[1] && rating[i] < list[2]) {
                list[k - 1] = rating[i];
                max_dfs(rating, k - 1, list);
                list[k - 1] = 0;
            }
        }
    }
}
