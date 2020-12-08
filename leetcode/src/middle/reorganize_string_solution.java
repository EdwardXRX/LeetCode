package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: reorganize_string_solution
 * @Author: EdwardX
 * @Description: 767. 重构字符串
 * @Date: 2020/11/30 15:21
 * @Version: 1.0
 */
public class reorganize_string_solution {
    public String reorganizeString(String S) {

        if(S.length() == 0 || S.length() == 1)
            return S;

        //集合用来存储S所有的元素
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            list.add(Integer.valueOf(S.charAt(i)));
        }

        //用来拼接字符串
        StringBuffer str = new StringBuffer();

        Boolean flag = true;

        while (flag)
        {

        }




        return "";

    }
}
