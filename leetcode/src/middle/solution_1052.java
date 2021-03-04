package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_1052
 * @Author: EdwardX
 * @Description: 1052. 爱生气的书店老板
 * @Date: 2021/2/23 10:04
 * @Version: 1.0
 */

/*
今天，书店老板有一家店打算试营业 customers.length 分钟。

每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

在某些时候，书店老板会生气。

如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。

2 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 

示例：

输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.

*/
public class solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //计算固有的数据
        int oldSum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                oldSum += customers[i];
            }
        }
        int max = oldSum;
        System.out.println("oldSum=" + oldSum);

        for (int i = X - 1; i < customers.length; i++) {
            int sum = oldSum;
            for (int j = i - X + 1; j <= i; j++) {
                if(grumpy[j] == 1){
                    sum += customers[j];
                }
            }
            System.out.println("sum=" + sum+"------- i=" + i);
            if(sum >= max){
                max = sum;
            }
        }
        return max;
    }

    public int getNums(int[] customers, int[] grumpy, int index, int x) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if ((i <= index && i > (index - x)) || grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        return sum;
    }
}
