package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_509
 * @Author: EdwardX
 * @Description: 509. 斐波那契数
 * @Date: 2021/1/4 8:41
 * @Version: 1.0
 */

/*
斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。

 

示例 1：

输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
示例 2：

输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2
示例 3：

输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3

*/
public class solution_509 {
    public static int fib(int n) {
        if(n == 1 || n == 0)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(19));
    }
}
