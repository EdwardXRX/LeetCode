package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1004
 * @Author: EdwardX
 * @Description: 1004. 最大连续1的个数 III
 * @Date: 2021/2/19 9:19
 * @Version: 1.0
 */
/*
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。

 

示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 

提示：

1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1 

*/


/*
滑动窗口的案例

利用左右指针，右指针不断向右边移动，如果出现0的个数大于K，
则左指针向右边移动。左指针遇到0，则0的个数自减1.

不断判断最长长度，最终返回此长度

*/
public class solution_1004 {
    public static int longestOnes(int[] A, int K) {
        int right = 0;
        int left = 0;
        int zeros = 0;
        int lens = 0;
        while(right < A.length){
            if(A[right] == 0){
                zeros++;
            }
            while (zeros > K){
                if (A[left++] == 0){
                    zeros--;
                }
            }
            lens = Math.max(lens,right - left +1);
            right++;
        }
        return lens;

    }

    //获得一个数组中最长连续1的个数
    public static int getMax(int[] A) {
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                int num = 0;
                int r = i;
                for (int x = i; x < A.length; x++) {
                    if (A[x] == 1)
                        num++;
                    else {
                        r = x;
                        break;
                    }
                }

                if (num > max)
                    max = num;

                i = r;
            }
        }
        return max;
    }

    public static int getNums(int index, int[] A) {
        int left = 0;      //记录左边1个数
        int right = 0;     //记录右边1个数

        //计算左边的连着的1的个数
        if (index != 0) {
            for (int i = index - 1; i >= 0; i--) {
                if (A[i] != 0) {
                    left++;
                } else {
                    break;
                }
            }
        }

        //计算右边的连着的1的个数
        if (index != A.length - 1) {
            for (int i = index + 1; i < A.length; i++) {
                if (A[i] != 0) {
                    right++;
                } else {
                    break;
                }

            }

        }

        return left + right + 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(A,k));
    }


}
