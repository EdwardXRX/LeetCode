package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: max_increase_to_keep_city_skyline_solution
 * @Author: EdwardX
 * @Description: 807. 保持城市天际线
 * @Date: 2020/10/17 8:59
 * @Version: 1.0
 */
public class max_increase_to_keep_city_skyline_solution {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        //获取每列最大值
        int[] col = new int[grid.length];
        //获取每行最大值
        int[] row = new int[grid.length];
        int max_row = 0;
        int max_col = 0;

        //找出每行每列得最大值，然后存入一维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] >= max_row) {
                    max_row = grid[i][j];
                }

                if (grid[j][i] >= max_col) {
                    max_col = grid[j][i];
                }
            }
            row[i] = max_row;
            col[i] = max_col;
            max_col = 0;
            max_row = 0;
        }

        for (int i = 0; i < row.length; i++) {
            System.out.println(row[i]);
            System.out.println("--------");
            System.out.println(col[i]);
        }

        int temp = 0;
        //开始计算
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                temp += (Math.min(col[j], row[i]) - grid[i][j]);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(nums));
    }
}
