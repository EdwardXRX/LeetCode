package easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1309
 * @Author: EdwardX
 * @Description: 1309. 解码字母到整数映射
 * @Date: 2020/12/28 7:55
 * @Version: 1.0
 */
public class solution_1309 {
    public static String freqAlphabets(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                stringBuffer.insert(0, (char) (Integer.valueOf(s.substring(i - 2, i)) + 96));
                i -= 2;
            } else {
                System.out.println(s.charAt(i));
                stringBuffer.insert(0, (char) (Integer.valueOf(String.valueOf(s.charAt(i))) + 96));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(freqAlphabets(s));


    }


}
