package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: li_wu_solution
 * @Author: EdwardX
 * @Description: 剑指 Offer 47. 礼物的最大价值
 * @Date: 2020/11/4 8:26
 * @Version: 1.0
 */
public class li_wu_solution {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};


    }


    public static int maxValue(int[][] grid) {
        int[][] new_grid = new int[grid.length][grid[0].length];

        //首先得把边界值给确定出来
        //也就是上边和左边得一行一列得值先确定

        //把左上角得值赋上，后面通过循环赋值总是出问题
        new_grid[0][0] = grid[0][0];

       /* //这是把左边一列给确定
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j <= i; j++) {
                new_grid[i][0] += grid[j][0];
            }
        }*/


        for (int i = 1; i < grid.length; i++) {
            new_grid[i][0] = new_grid[i-1][0] + grid[i][0];
        }

        for (int i = 0; i < new_grid[0].length; i++) {
            new_grid[0][i] = new_grid[0][i-1] +grid[0][i];
        }

        /*//这是把上面一行给确定
        for (int i = 1; i < grid[0].length; i++) {
            for (int j = 0; j <= i; j++) {
                new_grid[0][i] += grid[0][j];
            }
        }*/

        for (int i = 1; i < new_grid.length; i++) {
            for (int j = 1; j < new_grid[0].length; j++) {
                new_grid[i][j] = grid[i][j]+Math.max(new_grid[i - 1][j], new_grid[i][j - 1]);
            }
        }

        return new_grid[new_grid.length - 1][new_grid[0].length - 1];
    }
}
