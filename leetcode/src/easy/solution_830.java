package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_830
 * @Author: EdwardX
 * @Description: 830. 较大分组的位置
 * @Date: 2021/1/5 8:38
 * @Version: 1.0
 */
public class solution_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> listList = new ArrayList<>();
        if (s.length() <= 2) {
            return listList;
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        String str = stringBuffer.append('A').toString();
        int index = 0;
        char x = s.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (x != str.charAt(i)) {
                if ((i - index) >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    list.add(i - 1);
                    listList.add(new ArrayList<>(list));
                }
                index = i;
                x = str.charAt(i);
            }
        }
        return listList;
    }
}
