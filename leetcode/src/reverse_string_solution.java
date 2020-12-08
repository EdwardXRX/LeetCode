/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: reverse_string_solution
 * @Author: EdwardX
 * @Description: 344. 反转字符串
 * @Date: 2020/10/13 10:55
 * @Version: 1.0
 */
public class reverse_string_solution {
    public static void main(String[] args) {
        char[] s = {'1', '2', '3', '4','5'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
