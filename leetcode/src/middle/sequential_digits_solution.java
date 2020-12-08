package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: sequential_digits_solution
 * @Author: EdwardX
 * @Description: 1291. 顺次数
 * @Date: 2020/10/29 9:40
 * @Version: 1.0
 */

public class sequential_digits_solution {
    public List<Integer> sequentialDigits(int low, int high) {

        //存储答案
        List<Integer> list = new ArrayList<>();

        int max = low;
        int length_min = String.valueOf(low).length();
        int length_max = String.valueOf(high).length();

        for (int i = length_min; i <= length_max; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(low/Math.pow(10,i));


        }



        while (max < high)
        {

        }
        return list;
    }
}
