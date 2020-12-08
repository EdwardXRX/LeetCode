package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: game_of_life_solution
 * @Author: EdwardX
 * @Description: 289
 * @Date: 2020/10/6 9:03
 * @Version: 1.0
 */


/*
* 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
*/


public class game_of_life_solution {
    public static void main(String[] args) {

        int a[][] = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        a= gameOfLife(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println(" ");
        }


    }

    public static int[][] gameOfLife(int[][] board) {
        //board是一个二维数组。board.length是行数，而board.[i].length是列数
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((countLives(board, i, j) >= 0 && countLives(board, i, j) <= 1) || (countLives(board, i, j) >= 4 && countLives(board, i, j) <= 8)) {
                    board[i][j] = 2;
                } else if (countLives(board, i, j) == 2) {
                    if (board[i][j] == 0)
                        board[i][j] = 2;
                    else if (board[i][j] == 1)
                        board[i][j] = 3;
                } else if (countLives(board, i, j) == 3) {
                    board[i][j] = 3;
                }
            }
        }
        board = updateArray(board);
        return board;

    }

    //计算八个方向的活着的细胞数
    public static int countLives(int[][] b, int i, int j) {
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x > b.length - 1 || y < 0 || y > b[0].length - 1)
                continue;
            count += (b[x][y] & 1);
        }
        return count;
    }

    public static int[][] updateArray(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                switch (b[i][j]) {
                    case 2: {
                        b[i][j] = 0;
                        break;
                    }
                    case 3: {
                        b[i][j] = 1;
                        break;
                    }
                }
            }
        }

        return b;
    }
}
