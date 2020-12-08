package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: product_of_array_except_self_solution
 * @Author: EdwardX
 * @Description: 238. 除自身以外数组的乘积
 * @Date: 2020/10/12 10:09
 * @Version: 1.0
 */
public class product_of_array_except_self_solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];


        left[0] =1;
        right[nums.length-1] =1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i -1] * nums[i-1];
        }

        for(int j = nums.length -2 ; j >= 0; j-- )
        {
            right[j ] = right[j+1] *nums[j+1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }



}
