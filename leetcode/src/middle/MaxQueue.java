package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: dui_lie_de_zui_da_zhi_lcof_solution
 * @Author: EdwardX
 * @Description: 剑指 Offer 59 - II. 队列的最大值
 * @Date: 2020/10/31 9:56
 * @Version: 1.0
 */
public class MaxQueue {

    List<Integer> list;
    public MaxQueue() {
         list = new ArrayList<>();
    }

    public int max_value() {
        if(list.isEmpty() == true)
        {
            return -1;
        }
        Integer max = list.stream().reduce(Integer::max).get();
        return max;
    }

    public void push_back(int value) {
        list.add(value);

    }

    public int pop_front() {
        if(list.isEmpty() == true)
        {
            return -1;
        }
        int x = list.get(0);
        list.remove(0);
        return x;
    }

}
