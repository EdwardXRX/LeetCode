package middle;

import java.util.Arrays;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: shu_zu_once_2_solution
 * @Author: EdwardX
 * @Description: 剑指offer56_2
 * @Date: 2020/10/9 15:38
 * @Version: 1.0
 */
public class shu_zu_once_2_solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != nums[i + 1]) {
                temp = nums[i];
                return temp;
            } else {
                i += 2;
                if (i == nums.length - 2 && temp == 0) {
                    return nums[nums.length - 1];
                }
            }


        }
        return 0;

    }
}
