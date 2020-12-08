/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: single_number_solution
 * @Author: EdwardX
 * @Description: 136
 * @Date: 2020/9/26 16:38
 * @Version: 1.0
 */
public class single_number_solution {
    public int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if( i == j)
                    continue;

                if(nums[i] == nums[j])
                    flag = true;
            }

            if(flag==false)
                return nums[i];
        }
            return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4};
        System.out.println();
    }
}
