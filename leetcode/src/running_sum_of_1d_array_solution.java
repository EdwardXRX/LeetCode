/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: running_sum_of_1d_array_solution
 * @Author: EdwardX
 * @Description: 1480. 一维数组的动态和
 * @Date: 2020/10/17 7:37
 * @Version: 1.0
 */
public class running_sum_of_1d_array_solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        runningSum(nums);
    }

    public static int[] runningSum(int[] nums) {

        for (int i = 0; i < nums.length -1; i++) {
            nums[i + 1] += nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
        return nums;

    }
}
