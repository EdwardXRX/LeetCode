package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: jump_game_solution
 * @Author: EdwardX
 * @Description: 55. 跳跃游戏
 * @Date: 2020/10/28 10:41
 * @Version: 1.0
 */


/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
所以你永远不可能到达最后一个位置。

*/
public class jump_game_solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        //index代表每个位置最大的跳跃位置
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }

        //这是最远跳跃距离
        int max = nums[0];

        //判断标志
        boolean flag = true;

        //这是位置索引
        int find = 0;

        //判断主体
        while (max < nums.length - 1) {

            //用来判断每次小循环 是否有比自己大的跳跃位置
            //也就是if语句有没有被执行到
            boolean flag_small = true;

            //找到当前的位置 到 最远能跳跃位置 中间，是否有比自己更大的跳跃位置
            //为什么i = find + 1：
            //因为不用和自己比，直接从自己的后面那个元素开始向后比较
            int x= find;
            for (int i = x+1; i <= index[x]; i++) {
                if(index[i] > max)
                {
                    flag_small = false;
                    max = index[i];
                    find = i;
                }
            }

            //if条件没有发生
            if (flag_small)
            {
                find   = max;
                max = index[find];
            }

            //如果出现当前的find和index[find]相等
            //也就是当前的最大到达位置就是本身了，然后还没有到达最后一个位置
            //那就可以确定不能跳到最后
            //标志位记录false
            if(find  == index[find] && max < nums.length-1)
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
