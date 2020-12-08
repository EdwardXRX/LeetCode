package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: spiral_matrix_ii_solution
 * @Author: EdwardX
 * @Description: 59. 螺旋矩阵 II
 * @Date: 2020/10/11 10:10
 * @Version: 1.0
 */
public class spiral_matrix_ii_solution {


    int[][] array;  //定义一个全局变量，array

    public int[][] generateMatrix(int n) {
        array = new int[n][n];

        array[0][0] = 1;
        print_in(array, 0, 1, 2, true, true);


        return array;
    }


    /**
     * @param array     二维数组
     * @param i         行
     * @param j         列
     * @param index     当前数字
     * @param flag      flag == true ：行  flag == false ：列
     * @param direction direction == true : 如果是行，就是向右边行走，如果是列，就是向下行走
     *                  direction == false: 如果是行，就是向左边行走，如果是列，就是向上行走
     * @return 返回修改后的二维数组
     */
    public int[][] print_in(int[][] array, int i, int j, int index, boolean flag, boolean direction) {

        if (array.length % 2 == 0)     //说明n为偶数
        {
            if (i == array.length / 2 && j == array.length - 1)
                return array;
        }

        if (array.length % 2 == 1)      //说明n为奇数
        {
            if (i == array.length / 2 && j == array.length / 2)
                return array;
        }


        //按行走
        if (flag == true) {
            //往右走
            if (direction == true) {
                while (j < array.length || array[i][j] != 0) {
                    array[i][j + 1] = index;
                    j++;
                    index++;
                }

                print_in(array, i, j, index, false, true);
            }
            //往左走
            else {

                while (j >= 0 || array[i][j] != 0) {
                    array[i][j - 1] = index;
                    j--;
                    index++;
                }
                print_in(array,i,j,index,false,false);
            }
        }
        //按列走
        else {
            //向下走
            if (direction == true) {
                while (i <= array[0].length || array[i][j] != 0) {
                    array[i + 1][j] = index;
                    i++;
                    index++;
                }
                print_in(array,i,j,index,true,false);
            }
            //向上走
            else {

                    while (i >= 0 || array[i][j] != 0) {
                        array[i - 1][j] = index;
                        i--;
                        index++;
                    }
                    print_in(array,i,j,index,true,true);
            }
        }
        return array;
    }


}
