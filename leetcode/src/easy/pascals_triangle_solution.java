package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: pascals_triangle_solution
 * @Author: EdwardX
 * @Description: 118. 杨辉三角
 * @Date: 2020/12/6 8:33
 * @Version: 1.0
 */

/*
* 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class pascals_triangle_solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        if(numRows>0)
        {
            //如果numRows大于1
            //先把第一行填充
            List<Integer> list = new ArrayList<>();
            list.add(1);
            listList.add(list);

            //从第二行开始编辑
            for (int i = 1; i < numRows; i++) {
                List<Integer> list1 = new ArrayList<>();

                //前的1
                list1.add(1);
                //第二行都进不了for循环
                //所以直接就两个1.
                for (int j = 0; j < i-1; j++) {
                    list1.add(listList.get(listList.size()-1).get(j)+listList.get(listList.size()-1).get(j+1));
                }
                //后的1
                list1.add(1);
                listList.add(list1);
            }
        }


        return  listList;



    }
}
