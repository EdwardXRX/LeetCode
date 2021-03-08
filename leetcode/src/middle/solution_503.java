package middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_503
 * @Author: EdwardX
 * @Description: 503. 下一个更大元素 II
 * @Date: 2021/3/6 8:29
 * @Version: 1.0
 */
/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
输出每个元素的下一个更大元素。

数字 x 的下一个更大的元素是按数组遍历顺序，
这个数字之后的第一个比它更大的数，
这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。

*/
public class solution_503 {

    //单调栈
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }


    /*
    执行用时：59 ms, 在所有 Java 提交中击败了7.60%的用户
    内存消耗：39.4 MB, 在所有 Java 提交中击败了96.02%的用户
    */
    public static int[] nextGreaterElements1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            while (index != i) {
                if (index == nums.length) {
                    index = 0;
                    if (i == 0) {
                        break;
                    }
                }
                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                } else {
                    index++;
                }
            }
            if (index == i) {
                result[index] = -1;
            }
        }
        return result;
    }
}
