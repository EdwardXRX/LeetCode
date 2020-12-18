package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_389
 * @Author: EdwardX
 * @Description: 389. 找不同
 * @Date: 2020/12/18 9:25
 * @Version: 1.0
 */
/*
*   示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"


* */
public class solution_389 {
    public char findTheDifference(String s, String t) {
        int value = 0;
        for (int i = 0; i < t.length(); i++) {
            value += t.charAt(i);
            if(i<=t.length()-2)
            {
                value -= s.charAt(i);
            }
        }
        return (char)value;
    }


}
