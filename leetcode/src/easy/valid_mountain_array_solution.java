package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: valid_mountain_array_solution
 * @Author: EdwardX
 * @Description: 941. 有效的山脉数组
 * @Date: 2020/11/3 8:34
 * @Version: 1.0
 */
public class valid_mountain_array_solution {

    public static void main(String[] args) {
        int[] test = {0,3,2,1};
        System.out.println(validMountainArray(test));

    }
    public static boolean validMountainArray(int[] A) {
        //如果长度小于等于2，肯定不是山顶数组
        if (A.length <= 2) {
            return false;
        }
        boolean flag = false;
        //思路：
        //先找到山顶，然后再向两边延申，是否都是下坡，如果不是下坡，则直接判断为false


        for (int i = 0; i < A.length - 1; i++) {
            //找到第一个下坡点
            if (A[i + 1] < A[i]) {
                flag = true;
                //没有上坡
                if (i == 0)
                    return false;

                for (int j = i; j < A.length - 1; j++) {
                    if (A[j + 1] >= A[j])
                        return false;
                }
                for (int j = i; j > 0; j--) {
                    if (A[j - 1] >= A[j])
                        return false;
                }
                break;
            }
        }
        if(flag)
        {
            return true;
        }
        else
            return false;
    }

}
