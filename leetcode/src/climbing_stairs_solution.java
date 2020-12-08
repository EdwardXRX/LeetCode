/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: climbing_stairs_solution
 * @Author: EdwardX
 * @Description: 70
 * @Date: 2020/9/30 9:33
 * @Version: 1.0
 */
public class climbing_stairs_solution {
    static int ways = 0;

    public  static int climbStairs(int n) {
        findWays(n,0);
        return ways;

    }

    public  static int climbStairs1(int n) {
        if(n == 0)
        {
            ways ++;
            return ways;
        }
        else if(n < 0)
        {
            return -1;
        }
        else
        {
            climbStairs(n-1);
            climbStairs(n-2);
        }
        return ways;

    }

    public static void findWays(int n, int i) {
        n = n - i;
        if (n < 0) {
            return;
        } else if (n == 0) {
            ways++;
            return;
        } else {
            findWays(n, 1);
            findWays(n, 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(25));
    }

}
