import java.util.Arrays;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: squares_of_a_sorted_array_solution
 * @Author: EdwardX
 * @Description: 977. 有序数组的平方
 * @Date: 2020/10/16 8:17
 * @Version: 1.0
 */
public class squares_of_a_sorted_array_solution {
    public static int[] sortedSquares(int[] array) {
        if (array.length == 0)
            return null;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (Math.abs(array[j]) >Math.abs(array[j + 1]) ) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            array[array.length - 1 - i] = (int) Math.pow(array[array.length - 1 - i], 2);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        int[] get = sortedSquares(array);
        for (int i = 0; i < get.length; i++) {
            System.out.println(get[i]);
        }
    }
}
