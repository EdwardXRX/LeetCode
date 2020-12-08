/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: maximum_subarray_solution
 * @Author: EdwardX
 * @Description: 53
 * @Date: 2020/9/28 13:15
 * @Version: 1.0
 */
public class maximum_subarray_solution {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int back_max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {

            if(max <= nums[i])
                max = nums[i];

            if (temp + nums[i] <= 0) {
                temp = 0;
            }
            else
            {
                temp += nums[i];
                if (temp  >= back_max) {
                    back_max = temp;
                }
            }
        }
        if(back_max == 0)
            return max;
        return back_max;
    }

    public static void main(String[] args) {
        int[] xxx = {-5,-2,-1,-4};
        System.out.println(maxSubArray(xxx));
    }
}
