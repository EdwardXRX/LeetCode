package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: unique_paths_solution
 * @Author: EdwardX
 * @Description: 62. 不同路径
 * @Date: 2020/12/9 9:35
 * @Version: 1.0
 */

/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28

*/
public class unique_paths_solution {
    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        int[][] array = new int[m][n];

        //动态规划，直接遍历数组
        //反向思维。
        //我们判断每个格子，有多少来的路线就行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (array[i-1][j] == 0) {
                    array[i-1][j] = 1;
                }
                if(array[i][j-1] == 0)
                    array[i][j-1] = 1;
                array[i][j] = array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }

}
