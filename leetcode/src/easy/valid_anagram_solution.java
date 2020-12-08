package easy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: valid_anagram_solution
 * @Author: EdwardX
 * @Description: 242. 有效的字母异位词
 * @Date: 2020/11/22 9:52
 * @Version: 1.0
 */
public class valid_anagram_solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] str1 = new int[s.length()];
        int[] str2 = new int[t.length()];

        for (int i = 0; i < s.length(); i++) {
            str1[i] = (int)s.charAt(i);
            str2[i] = (int)t.charAt(i);
        }

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < str1.length; i++) {
            if(str1[i] != str2[i])
                return false;
        }


        return true;
    }


}
