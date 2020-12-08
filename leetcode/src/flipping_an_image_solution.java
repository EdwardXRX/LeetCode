/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: flipping_an_image_solution
 * @Author: EdwardX
 * @Description: 832
 * @Date: 2020/10/7 20:41
 * @Version: 1.0
 */
public class flipping_an_image_solution {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {

            if (A[0].length % 2 == 1) {
                if (A[i][A[0].length / 2] == 1)
                    A[i][A[0].length / 2] = 0;
                else
                    A[i][A[0].length / 2] = 1;
            }
            for (int j = 0; j < A[0].length / 2; j++) {

                if (A[i][j] == 0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;


                if (A[i][A[0].length - j - 1] == 0)
                    A[i][A[0].length - j - 1] = 1;
                else
                    A[i][A[0].length - j - 1] = 0;


                int temp = A[i][j];
                A[i][j] = A[i][A[0].length - j - 1];
                A[i][A[0].length - j - 1] = temp;
            }
        }
        return A;
    }
}
