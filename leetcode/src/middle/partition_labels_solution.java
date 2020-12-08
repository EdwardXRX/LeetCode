package middle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: partition_labels_solution
 * @Author: EdwardX
 * @Description: 763. 划分字母区间
 * @Date: 2020/10/22 7:53
 * @Version: 1.0
 */


/*
        输入：S = " a b a b c b a c a d e f e g d e h i j h k l i j"
                    0 1 2 3 4 5 6 7 8 9 10...
        输出：[9,7,8]
解释：
        划分结果为 "ababcbaca", "defegde", "hijhklij"。
        每个字母最多出现在一个片段中。
        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

*/
public class partition_labels_solution {

    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.equals(""))
            return null;
        List<Integer> list = new ArrayList<>();

        //通过一个一维数组，获得每个元素得最后出现得下标
        int[] last = new int[28];
        //用一个一维数组，记录每个元素出现得起始位置
        int[] start = new int[28];


        for (int i = 0; i < last.length; i++) {
            start[i] = -1;
            last[i] = -1;
        }
        //start数组存入每个字母得起始位置
        //last数组存入每个元素得最终出现位置
        for (int i = 0; i < S.length(); i++) {
            if (start[S.charAt(i) - 96] == -1) {
                start[S.charAt(i) - 96] = i;
            }
            last[S.charAt(i) - 96] = i;
        }




        //快慢指针。分别指向某一数据段得第一位置和最后位置
        int begin = start[(int) S.charAt(0) -96];
        int end = last[(int) S.charAt(0) -96];


        //遍历字符串S中所有字符，进行判断
        for (int i = 0; i < S.length(); i++) {

            //说明在某一数据段内起始范围内，说明当前元素还是当前数据段得元素
            if(start[(int)S.charAt(i) - 96]>= begin && start[(int)S.charAt(i) -96]<= end)
            {
                //更新快指针
                if (last[(int)S.charAt(i) -96] > end) {
                    end = last[(int)S.charAt(i) -96];
                }
                //不需要更新边界，但是如果到了最后一个元素，也需要直接把长度加进去了
                else {
                    if (i == S.length() - 1)
                        list.add(end - begin + 1);
                }
            }
            else if(start[(int)S.charAt(i) -96] > end)
            {
                list.add(end - begin + 1);
                begin = start[(int)S.charAt(i) -96];
                end = last[(int)S.charAt(i) -96];
                if (i == S.length() - 1)
                    list.add(end - begin + 1);
            }

        }
        return list;

    }

    public static void main(String[] args) {
        String S = "ababzcbacadefegzdehijhklij";
        System.out.println(partitionLabels(S));

    }


}
