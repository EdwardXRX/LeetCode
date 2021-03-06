package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: ccw6C7
 * @Author: EdwardX
 * @Description: LCP 22. 黑白方格画
 * @Date: 2020/11/24 9:17
 * @Version: 1.0
 */
/*
* 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。

小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。

注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。

示例 1：

输入：n = 2, k = 2

输出：4

解释：一共有四种不同的方案：
第一种方案：涂第一列；
第二种方案：涂第二列；
第三种方案：涂第一行；
第四种方案：涂第二行。

示例 2：

输入：n = 2, k = 1

输出：0

解释：不可行，因为第一次涂色至少会涂两个黑格。

示例 3：

输入：n = 2, k = 4

输出：1

解释：共有 2*2=4 个格子，仅有一种涂色方案。

限制：

1 <= n <= 6
0 <= k <= n * n

*/
public class ccw6C7 {
    public int paintingPlan(int n, int k) {
        if (n > k) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(n*i + n*j - i*j == k)
                {
                    count += zuhe(n,i)*zuhe(n,j);
                }
            }
        }


        return count;
    }


    public static void main(String[] args) {
        System.out.println(zuhe(6,3));
    }
    public static int zuhe(int n , int i)
    {
        if(i == 0)
            return 0;
        int mom = 1;
        int son =1;

        for (int x = 0; x < i; x++) {
            mom = mom *n;
            n = n-1;
        }

        for (int y = i; y>=1; y--) {
            son = son*y;
        }

        return mom/son;
    }
}
