import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: reverse_words_in_a_string_iii_solution
 * @Author: EdwardX
 * @Description: 557. 反转字符串中的单词 III
 * @Date: 2020/10/13 11:02
 * @Version: 1.0
 */
public class reverse_words_in_a_string_iii_solution {

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest" ;
        String str_new = reverseWords(str);
        System.out.println(str_new);
    }
    public static String reverseWords(String s) {
        StringBuilder strBuilder = new StringBuilder(s);
        strBuilder.append(" ");

        Stack<Character> stack = new Stack<>();
        int temp = 0;

        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) != ' ' ) {
                temp++;
                stack.push((char) strBuilder.charAt(i));
            } else if(strBuilder.charAt(i) == ' '){
                for (int j = i - temp; j < i; j++) {
                    strBuilder.setCharAt(j, stack.pop());
                }
                temp = 0;
            }
        }
        strBuilder.deleteCharAt(strBuilder.length()-1);
        return strBuilder.toString();

    }
}
