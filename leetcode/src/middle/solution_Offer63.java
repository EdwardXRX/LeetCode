package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_Offer63
 * @Author: EdwardX
 * @Description: 剑指 Offer 63. 股票的最大利润
 * @Date: 2021/3/4 8:08
 * @Version: 1.0
 */
/*假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

 

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，
在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

*/
public class solution_Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] > prices[i] && (prices[j] - prices[i]) > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int max = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[index]){
                max += (prices[i]- prices[index]);
                index = i;
            }
        }
        return max;
    }



}
