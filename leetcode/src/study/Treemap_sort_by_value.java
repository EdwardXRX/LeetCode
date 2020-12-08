package study;

import java.util.*;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: study
 * @ClassName: Treemap_sort_by_value
 * @Author: EdwardX
 * @Description: 红黑树通过value排序
 * @Date: 2020/11/17 8:23
 * @Version: 1.0
 */
public class Treemap_sort_by_value {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("A", 30);
        map.put("B", 90);
        map.put("C", 80);
        map.put("D", 65);
        map.put("E", 89);
        map.put("F", 75);
        //对value进行排序
        //将map.entrySet()转换为list集合
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
