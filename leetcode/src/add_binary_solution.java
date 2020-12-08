import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: add_binary_solution
 * @Author: EdwardX
 * @Description: 67
 * @Date: 2020/9/26 20:21
 * @Version: 1.0
 */
public class add_binary_solution {


    static Stack<Integer> stack = new Stack<Integer>();


    public static String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;

        //对每一位进行相加，如果=2就进一。
        //从最后一位对齐，所以存在肯能前面为空情况，所以用0去处理；
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        //对高位，如果在最后有进1情况，就直接添加一个'1'
        if (carry > 0) {
            ans.append('1');
        }
        //最后逆置
        ans.reverse();

        //返回的是打印成String类得字符串
        return ans.toString();
    }


    public static String addBinary(String a, String b) {

        int sum = Integer.parseInt(a) + Integer.parseInt(b);

        test(sum, 0);
        String str = "";
        for (Integer x : stack) {

            str = x.toString().concat(str);

        }
        if (str == "" || str.equals("") || str == null)
            return "0";
        return str;


    }

    public static void test(int sum, int temp) {
        if (sum == 0) {
            if (temp == 1)
                stack.push(1);
            return;
        }

        if ((temp + sum % 10) == 3) {
            temp = 1;
            stack.push(1);
        } else if ((temp + sum % 10) == 2) {
            temp = 1;
            stack.push(0);
        } else if ((temp + sum % 10) == 0 || (temp + sum % 10) == 1) {

            stack.push(temp + sum % 10);
            temp = 0;
        }

        test(sum / 10, temp);
    }

    public static void main(String[] args) {


        String str = addBinary2("1010", "1011");
        System.out.println(str);

    }
}
