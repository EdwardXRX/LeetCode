/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: how_many
 * @Author: EdwardX
 * @Description: 1365. 有多少小于当前数字的数字
 * @Date: 2020/10/26 8:09
 * @Version: 1.0
 */
public class how_many {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count =0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j])
                {
                    count ++;
                }
            }
            result[i] = count;
        }
        return result;
    }

}
