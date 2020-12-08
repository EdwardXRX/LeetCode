package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: find_last_and_first_34
 * @Author: EdwardX
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Date: 2020/12/1 8:31
 * @Version: 1.0
 */
public class find_last_and_first_34 {
    public int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        for (int j = nums.length; j > 0; j--) {
            if(nums[j] == target)
            {
                end = j;
                break;
            }
        }

        int[] result = new int[2];

        result[0] = start;
        result[1] = end;

        return result;
    }
}
