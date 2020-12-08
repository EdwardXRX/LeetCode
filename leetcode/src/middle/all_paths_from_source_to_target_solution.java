package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: all_paths_from_source_to_target_solution
 * @Author: EdwardX
 * @Description: 797. 所有可能的路径
 * @Date: 2020/10/10 9:45
 * @Version: 1.0
 */
public class all_paths_from_source_to_target_solution {

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> test_result = new ArrayList<>();
        test_result = allPathsSourceTarget(graph);

        for (List<Integer> list : test_result) {
            System.out.println(list);
        }


    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list, 0);
        return lists;

    }

    public static void dfs(int[][] graph, List<Integer> list, int index) {
        if (graph[index].length == 0 && index == graph.length-1) {
            lists.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < graph[index].length; i++) {
            list.add(graph[index][i]);
            dfs(graph, list, graph[index][i]);
            list.remove(list.size() - 1);
        }

    }

}
