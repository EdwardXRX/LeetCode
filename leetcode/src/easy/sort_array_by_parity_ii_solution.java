package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: sort_array_by_parity_ii_solution
 * @Author: EdwardX
 * @Description: 922. 按奇偶排序数组 II
 * @Date: 2020/11/12 10:15
 * @Version: 1.0
 */
/*
* 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 

示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 

提示：

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000

*/
public class sort_array_by_parity_ii_solution {

    public int[] sortArrayByParity(int[] A) {
        //双指针
        //一个从前向后
        //一个从后向前
        //i指针专门找偶数位出现问题的数字
        //j指针专门找奇数位出现问题的数字
        int i = 0;                  //0为偶数
        int j = A.length - 1;         //A.length-1必为奇数
        boolean flag = true;
        while (flag) {

            //从前向后找偶数位不符合要求的下标索引
            while (i < A.length - 1) {
                if (i % 2 == 0 && A[i] % 2 == 0) {
                    i += 2;
                } else {
                    break;
                }
            }

            //从后往前找奇数位不符合要求的下标索引
            while (j > 0) {
                if (j % 2 == 1 && A[j] % 2 == 1) {
                    j -= 2;
                } else {
                    break;
                }
            }

            //两个while都结束了，此时都停留在各自出问题的下标位置中，只需要交换即可；
            if(i<A.length+1 && j > -1)
            {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

            //循环出口判断；
            if (i==A.length+1 && j == -1)
            {
                break;
            }
        }
        return A;
    }

    public int[] sortArrayByParityII(int[] A) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }

        //偶数索引
        int i = 0;
        //奇数索引
        int j = 1;

        while (list.isEmpty() == false) {
            if (list.get(list.size() - 1) % 2 == 0) {
                A[i] = list.remove(list.size() - 1);
                i += 2;
            } else {
                A[j] = list.remove(list.size() - 1);
                j += 2;
            }
        }
        return A;

    }
}
