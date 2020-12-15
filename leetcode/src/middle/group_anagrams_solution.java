package middle;

import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: group_anagrams_solution
 * @Author: EdwardX
 * @Description: 49. 字母异位词分组
 * @Date: 2020/12/14 9:25
 * @Version: 1.0
 */

/*
示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
public class group_anagrams_solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long,List<String>> hm = new HashMap<Long,List<String>>();
        List<List<String>> lls = new ArrayList<List<String>>();
        for(String s : strs){
            long res = getNum(s);
            List<String> lst = new ArrayList<>();
            if(hm.containsKey(res)){
                hm.get(res).add(s);
            }else{
                lst.add(s);
                hm.put(res,lst);
            }
        }
        for(Map.Entry<Long, List<String>> entry : hm.entrySet()){
            lls.add(entry.getValue());
        }
        return lls;
    }

    public long getNum(String s){
        int[] n = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        long res = 1;
        for(char c : s.toCharArray()){
            res = res * n[(int)c-(int)'a'];
        }
        return res;
    }
}

