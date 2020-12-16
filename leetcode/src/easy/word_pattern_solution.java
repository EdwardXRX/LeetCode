package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: word_pattern_solution
 * @Author: EdwardX
 * @Description: 290. 单词规律
 * @Date: 2020/12/16 8:54
 * @Version: 1.0
 */

/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    

* */
public class word_pattern_solution {
    public static boolean wordPattern(String pattern, String s) {
        //将字符串分割成s
        String[] strArr= s.split(" ");
        if(pattern.length() != strArr.length)
        {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if(map.containsKey(pattern.charAt(i)) == true)
            {
                if(map.get(pattern.charAt(i)).equals(strArr[i]) == false)
                    return false;
            }
            else
            {
                if(map.containsValue(strArr[i]) == true)
                {
                    return false;
                }
                else
                {
                    map.put(pattern.charAt(i),strArr[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        System.out.println(wordPattern("abba",s));

    }
}
