package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: intersection_of_two_arrays_solution
 * @Author: EdwardX
 * @Description: 349. 两个数组的交集
 * @Date: 2020/11/2 8:25
 * @Version: 1.0
 */

public class intersection_of_two_arrays_solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //数组1存入list2当中
        for (int i = 0; i < nums1.length; i++) {
            if (list2.contains(nums1[i]) == false) {
                list2.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (list2.contains(nums2[i]) == true) {
                if (list1.contains(nums2[i]) == false) {
                    list1.add(nums2[i]);
                }
            }
        }
        int[] result = new int[list1.size()];
        int index = 0;
        for (int i : list1) {
            result[index] = i;
            index++;
        }
        return result;
    }
}
