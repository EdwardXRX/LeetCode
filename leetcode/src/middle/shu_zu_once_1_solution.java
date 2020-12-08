package middle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: shu_zu_once_1_solution
 * @Author: EdwardX
 * @Description: 剑指offer56_1
 * @Date: 2020/10/9 13:53
 * @Version: 1.0
 */
public class shu_zu_once_1_solution {

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        int[] result = singleNumbers3(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] singleNumbers3(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[3];
        int index = 0;


        for (int i = 0; i < nums.length; i++) {
            if(temp[0] == 0)
            {
                temp[0] = nums[i];
            }
            else
            {
                if(nums[i] != temp[index])
                {
                    temp[index +1 ] = nums [i];
                    index++;
                }
                else
                {
                    if(index > 0)
                        index--;

                }
            }
        }

        int[] good = new int[2];
        good[0] = temp [0];
        good[1] = temp [1];
        return good;
    }
    public static int[] singleNumbers(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[2];
        int temp = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty() == false)
            {
                if(stack.peek() == nums[i]) {
                    stack.pop();
                }
                else
                    stack.push(nums[i]);

            }
            else stack.push(nums[i]);
            }
        result[0] = stack.pop();
        result[1] = stack.pop();

        return result;
    }
    public static int[] singleNumbers2(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i + 1]) {
                i++;
                if( i == nums.length-2)
                    result[1] = nums[nums.length -1];
            }
            else
            {

                if(i == nums.length-2 && result == null)
                {
                    result[0] = nums[nums.length-2];
                    result[1] = nums[nums.length-1];
                }

                result[temp] = nums[i];
                temp++;
            }

        }

        return result;
    }


}
