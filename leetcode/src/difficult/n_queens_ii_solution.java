package difficult;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: difficult
 * @ClassName: n_queens_ii_solution
 * @Author: EdwardX
 * @Description: 52. N皇后 II
 * @Date: 2020/10/17 10:22
 * @Version: 1.0
 */
public class n_queens_ii_solution {

    //全局变量num，用来计数
    private static int num = 0;

    public static int totalNQueens(int n) {
        //模拟棋盘
        //int[][] array = new int[n][n];

        //用来保存每一行中元素得列数,从1行为起始
        int[] queen = new int[n + 1];
        //把标记数组所有元素设置为-1
        for (int i = 0; i < n + 1; i++) {
            queen[i] = -1;
        }
        dfs(n, n, 1, queen);
        return num;
    }

    public static void dfs(int n, int count, int row, int[] queen) {
        for (int col = 1; col <= n; col++) {
            if (count == 0) {
                num++;
                return;
            }

            if (available(row, col, queen)) {
                queen[row] = col;
                dfs(n, count--, row + 1, queen);
                queen[row] = -1;
            }

        }
    }

    public static boolean available(int row, int col, int[] queen) {//判断某个皇后是否与已有皇后冲突
        for (int i = 1; i < row; i++) {
            if (col == queen[i]) return false;//同一列拒绝
            if ((row - i) == (  col - queen[i])) return false;//同一主对角线拒绝
            if ((row - i) + (col - queen[i]) == 0) return false;//同一副对角线拒绝
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(totalNQueens(n));
    }
}
