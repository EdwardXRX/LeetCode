package easy;

import java.util.Arrays;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_455
 * @Author: EdwardX
 * @Description: 455. 分发饼干
 * @Date: 2020/12/25 9:29
 * @Version: 1.0
 */

/*
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。


示例 1:

输入: g = [1,2,3], s = [1,1]
输出: 1
解释:
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
示例 2:

输入: g = [1,2], s = [1,2,3]
输出: 2
解释:
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.
 

提示：

1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1

*/
public class solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        //如果两个数组，有任何一个（孩子人数为0，或者饼干数为0）
        if (s.length == 0 || g.length == 0)
            return 0;

        //小孩个数
        int length_g = g.length - 1;
        //饼干个数
        int length_s = s.length - 1;

        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        while (length_g >= 0 && length_s >= 0) {
            if(s[length_s] >= g[length_g] )
            {
                length_s--;
                length_g--;
                result++;
            }else if(s[length_s] < g[length_g])
            {
                length_g--;
            }
        }
        return result;
    }


}
