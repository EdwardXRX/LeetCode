package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: relative_sort_array_solution
 * @Author: EdwardX
 * @Description: 1122. 数组的相对排序
 * @Date: 2020/11/14 10:03
 * @Version: 1.0
 */

/*
* 给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
*/
public class relative_sort_array_solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        //新建一个集合，把数组2的元素全部存入
        List<Integer> list = new ArrayList<>();
        for (int i = arr2.length - 1; i >= 0; i--) {
            list.add(arr2[i]);
        }

        int[] new_arr = new int[arr1.length];
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[j] == arr2[i])
                {
                    new_arr[index] = arr1[j];
                    index++;
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if(list.contains(arr1[i]) == false)
            {
                new_arr[index] = arr1[i];
                index++;
            }
        }



        return new_arr;
    }

}
