package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: rotate_imag_solution_2
 * @Author: EdwardX
 * @Description: 48. 旋转图像_解法2
 * @Date: 2020/10/13 8:04
 * @Version: 1.0
 */
public class rotate_imag_solution_2 {


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8,}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
                System.out.print(",");
            }
            System.out.println("");
        }

        rotate(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
                System.out.print(",");
            }
            System.out.println("");
        }


    }

    public static void rotate(int[][] matrix) {

        //用length记录二维数组的n的下标边界
        int length = matrix.length;

        for (int i = 0; i < length / 2 ; i++) {
            for (int j = i; j < length - i -1 ; j++) {
                swap(i, j, matrix);
            }
        }

    }

    private static void swap(int i, int j, int[][] array) {
        int temp;
        //保存当前结点；用作第三空间交换四个边的数值；

        /*array[i][j] = array[j][array.length -1 -i] ;
        array[j][array.length -1 -i] = array[array.length -1 -j][array.length -1 -i];*/

        temp = array[i][j];
        array[i][j] = array[array.length - 1 - j][i];
        array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
        array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
        array[j][array.length - 1 - i] = temp;

    }

}
