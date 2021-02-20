package easy;

import java.util.*;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_697
 * @Author: EdwardX
 * @Description: 697. 数组的度
 * @Date: 2021/2/20 10:10
 * @Version: 1.0
 */

/*
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 

示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2：

输入：[1,2,2,3,1,4,2]
输出：6

*/
public class solution_697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], (map.get(nums[i])) + 1);
            }
        }

        Set<Integer> sett = map.keySet();
        for(int sss : sett){
            System.out.println("key:" + sss);
            System.out.println("value:" + map.get(sss));
            System.out.println("--------------------");
        }

        int maxNums = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if(map.get(key) > maxNums){
                System.out.println("maxNums:" + maxNums);
                maxNums = map.get(key);
                list.clear();
                list.add(key);
            }
            else if(map.get(key) == maxNums){
                list.add(key);
            }
        }


        int min = 49999;
        for (int i = 0; i < list.size(); i++) {
            int left = 0;
            int right = 0;
            for (int m = 0; m < nums.length; m++) {
                if (nums[m] == list.get(i))
                {
                    left = m;
                    break;
                }
            }


            for (int n = nums.length-1; n >= 0; n--) {
                if(nums[n] == list.get(i)){
                    right = n;
                    break;
                }
            }
            System.out.println("i=" + i);
            System.out.println("left"+ left);
            System.out.println("right" + right);

            if((right - left +1) < min)
                min = (right - left +1);

        }


        /*int Min_lens = 49999;
        int Max_frequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int frequency = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    frequency++;
                    index = j;
                }
            }

            if (frequency > Max_frequency) {
                Max_frequency = frequency;
                Min_lens = (index - i + 1);
            }
            if (frequency == Max_frequency && (index - i + 1) < Min_lens) {
                Min_lens = (index - i + 1);
            }
        }*/
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));

    }
}
