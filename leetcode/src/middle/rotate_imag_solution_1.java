package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: rotate_imagsolution
 * @Author: EdwardX
 * @Description: 48. 旋转图像
 * @Date: 2020/10/13 7:26
 * @Version: 1.0
 */
public class rotate_imag_solution_1 {
    public void rotate(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                list.add(matrix[i][j]);
            }
        }


        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length-1; i >= 0; i--) {
                matrix[i][j] = list.get(list.size() -1);
                list.remove(list.size()-1);
            }
        }
    }
}
