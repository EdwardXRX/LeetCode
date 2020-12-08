package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: score_after_solution
 * @Author: EdwardX
 * @Description: 861. 翻转矩阵后的得分
 * @Date: 2020/12/7 8:17
 * @Version: 1.0
 */
public class score_after_solution {
    public static int matrixScore(int[][] A) {
        //把每一行都进行判断
        System.out.println(A.length);
        for (int i = 0; i < A.length; i++) {
            if(A[i][0] == 0) {
                A[i] = isTurnRow(A[i]);
            }
        }


        int score = 0;
        for (int i = 0; i < A[0].length; i++) {

            int nums_0 = 0;
            for (int j = 0; j < A.length; j++) {
                if(A[j][i] == 0)
                    nums_0 += 1;
            }

            //如果当前列中，1的个数大于0 的个数，直接按照A.length-nums_0 的个数求和
            if(A.length-nums_0 > nums_0)
            {
                score += (A.length-nums_0) * Math.pow(2,A[0].length-i-1);
            }
            else
            {
                score += nums_0 * Math.pow(2,A[0].length-i-1);
            }
        }


        return score;

    }


    //判断行是否进行翻转。
    //如果需要翻转，则返回true
    //不翻转，就返回false
    public static int[] isTurnRow(int[] row)
    {

        //行翻转
        for (int i = 0; i < row.length; i++) {
            if(row[i] == 1)
                row[i] = 0;
            else if(row[i] == 0)
                row[i] = 1;
        }

        return row;

    }

    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(A));


    }


}
