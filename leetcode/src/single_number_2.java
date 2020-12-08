import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: single_number_2
 * @Author: EdwardX
 * @Description: 136
 * @Date: 2020/9/27 8:19
 * @Version: 1.0
 */
public class single_number_2 {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    public static void main(String[] args) {


    }
}
