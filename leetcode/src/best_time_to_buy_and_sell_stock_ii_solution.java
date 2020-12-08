/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: best_time_to_buy_and_sell_stock_ii_solution
 * @Author: EdwardX
 * @Description: 122
 * @Date: 2020/9/25 17:07
 * @Version: 1.0
 */
public class best_time_to_buy_and_sell_stock_ii_solution {


    public static  int maxProfit(int[] prices) {

        //定义一个整数的profit，专门记录盈利总额
        int profit = 0;

        //单层for循环，对所有价格进行判断
        //
        for (int i = 0; i < prices.length - 1; i++) {
            if (  prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {21,1,20};
        int profit = maxProfit(array);
        System.out.println(profit);

    }
}
