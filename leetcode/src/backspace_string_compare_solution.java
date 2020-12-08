import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: backspace_string_compare_solution
 * @Author: EdwardX
 * @Description: 844. 比较含退格的字符串
 * @Date: 2020/10/19 11:12
 * @Version: 1.0
 */
public class backspace_string_compare_solution {

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
    }


    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();


        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (stack1.isEmpty() == false) {
                    stack1.pop();
                }
            } else {
                stack1.push(S.charAt(i));
            }

        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (stack2.isEmpty() == false) {
                    stack2.pop();
                }
            } else {
                stack2.push(T.charAt(i));
            }

        }
        StringBuffer ssss1 = new StringBuffer();
        StringBuffer ssss2 = new StringBuffer();
        while (stack1.isEmpty() == false) {
            ssss1.append(stack1.pop());
        }
        while (stack2.isEmpty() == false) {
            ssss2.append(stack2.pop());
        }


        System.out.println(ssss1.toString());
        System.out.println(ssss2.toString());


        if (ssss1.toString().equals(ssss2.toString())) {
            return true;
        } else
            return false;
    }
}


