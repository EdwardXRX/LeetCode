package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_189
 * @Author: EdwardX
 * @Description: 189. 旋转数组
 * @Date: 2021/1/8 9:17
 * @Version: 1.0
 */

/*
*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

*/
public class solution_189 {
    public void rotate(int[] nums, int k) {

        if (k == 0 || nums.length == 0 || k % (nums.length) == 0)
            return;

        if (k > nums.length) {
            k = k % (nums.length);
        }
        int i = 0;
        while (i < k) {
            int t = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = t;
        }
    }
}
