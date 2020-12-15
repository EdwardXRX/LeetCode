package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: monotone_increasing_digits_solution
 * @Author: EdwardX
 * @Description: 738. 单调递增的数字
 * @Date: 2020/12/15 9:08
 * @Version: 1.0
 */
/*

给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9

示例 2:

输入: N = 1234
输出: 1234

示例 3:

输入: N = 332
输出: 299

*/
public class monotone_increasing_digits_solution {
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        char[] chars = s.toCharArray();
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));

    }

    public static void main(String[] args) {
        int N = 1234567;
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(N));
        stringBuffer.setCharAt(1,'x');



    }
}
