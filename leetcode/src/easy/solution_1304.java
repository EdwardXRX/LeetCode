package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1304
 * @Author: EdwardX
 * @Description: 1304. 和为零的N个唯一整数
 * @Date: 2020/12/24 8:47
 * @Version: 1.0
 */

/*
* 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。

示例 1：

输入：n = 5
输出：[-7,-1,1,3,4]
解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
示例 2：

输入：n = 3
输出：[-1,0,1]
示例 3：

输入：n = 1
输出：[0]

*/
public class solution_1304 {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 1) {
            n--;
        }
        for (int x = 0; x < n; x++) {
            if (x % 2 == 0) {
                result[x] = (x/2 + 1);
            } else {
                result[x] = -(x/2 + 1);
            }
        }
        if (n % 2 == 0)
            result[n] = 0;
        return result;
    }
}
