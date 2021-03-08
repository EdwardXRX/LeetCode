package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_131
 * @Author: EdwardX
 * @Description: 131. 分割回文串
 * @Date: 2021/3/7 14:11
 * @Version: 1.0
 */
/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

*/
public class solution_131 {
    List<List<String>> lists = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        //如果是空字符串，直接返回空的集合
        if (s.equals("") || s.length() == 0)
            return lists;
        List<String> list = new ArrayList<>();
        dfs(list, s, s.length());
        return lists;
    }

    public void dfs(List<String> list, String s, int length) {
        if (length < 0) {
            return;
        }
        if (length == 0) {
            if (lists.contains(list) == false) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isThat(s.substring(0, i))) {
                list.add(s.substring(0, i));
                dfs(list, s.substring(i, s.length()), length - i);
                list.remove(list.size() - 1);
            }
        }
    }

    public Boolean isThat(String s) {
        Boolean aBoolean = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                aBoolean = false;
            }
        }
        return aBoolean;
    }
    public boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    public static void main(String[] args) {
        String s = "0123456789";
        System.out.println(s.substring(1, 10));
    }


}
