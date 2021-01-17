package easy;


import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1018
 * @Author: EdwardX
 * @Description: 1018. 可被 5 整除的二进制前缀
 * @Date: 2021/1/14 9:16
 * @Version: 1.0
 */
public class solution_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();

        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            list.add(sum % 5 == 0);
            sum = sum *2;
        }
        return list;

    }
}
