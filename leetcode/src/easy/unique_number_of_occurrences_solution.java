package easy;

import java.util.*;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: unique_number_of_occurrences_solution
 * @Author: EdwardX
 * @Description: 1207. 独一无二的出现次数
 * @Date: 2020/10/28 9:19
 * @Version: 1.0
 */
public class unique_number_of_occurrences_solution {
    public boolean uniqueOccurrences(int[] arr) {

        //用map存储次数
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]) == false)
            {
                map.put(arr[i],0);
            }
            else
            {
                map.put(arr[i],map.get(arr[i]) +1);
            }
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> keys = map.keySet();   //此行可省略，直接将map.keySet()写在for-each循环的条件中
        for(Integer key:keys){
            if(list.contains(map.get(key)) == false)
            {
                list.add(map.get(key));
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
