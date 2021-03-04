package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_304
 * @Author: EdwardX
 * @Description: 304. 二维区域和检索 - 矩阵不可变
 * @Date: 2021/3/2 8:33
 * @Version: 1.0
 */
public class solution_304 {

    int[][] matrix = null;
    public solution_304(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //最左上角不需要操作
                if (i == 0 && j == 0) {
                    continue;
                }
                //最上行只需要算左边的和
                else if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else {
                    matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }
            this.matrix = matrix;
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return matrix[row2][col2];
        } else if (row1 == 0) {
            return matrix[row2][col2] - matrix[row2][col1 - 1];
        } else if (col1 == 0) {
            return matrix[row2][col2] - matrix[row1 - 1][col2];
        } else {
            return matrix[row2][col2] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2] + matrix[row1 - 1][col1 - 1];
        }

    }
}
