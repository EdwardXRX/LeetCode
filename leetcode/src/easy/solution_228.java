package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_228
 * @Author: EdwardX
 * @Description: 228. 汇总区间
 * @Date: 2021/1/10 13:13
 * @Version: 1.0
 */

/*
给定一个无重复元素的有序整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。

也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b
 

示例 1：

输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
示例 2：

输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
示例 3：

输入：nums = []
输出：[]
示例 4：

输入：nums = [-1]
输出：["-1"]
示例 5：

输入：nums = [0]
输出：["0"]

*/
public class solution_228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(nums[i]));
            int m = i + 1;
            while (m < nums.length) {
                if (nums[m] == nums[m - 1] + 1)
                    m++;
                else break;
            }
            //说明当前下标为i的元素为单独的集合
            if (m == i + 1) {
                list.add(stringBuffer.toString());
                i++;
            }
            //不是独立的个体，是有范围的
            else {
                stringBuffer.append("->");
                stringBuffer.append(String.valueOf(nums[m-1]));
                i = m;
                list.add(stringBuffer.toString());
            }

        }

        return list;


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7,9,10,11,14,17};
        List<String> list = summaryRanges(nums);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
