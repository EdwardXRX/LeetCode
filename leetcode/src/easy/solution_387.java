package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_387
 * @Author: EdwardX
 * @Description: 387. 字符串中的第一个唯一字符
 * @Date: 2020/12/23 8:55
 * @Version: 1.0
 */
public class solution_387 {
    public int firstUniqChar(String s) {
        char[] map = new char[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
