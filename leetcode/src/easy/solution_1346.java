package easy;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1346
 * @Author: EdwardX
 * @Description: 1346. 检查整数及其两倍数是否存在
 * @Date: 2020/12/19 9:04
 * @Version: 1.0
 */

/*
* 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，
* 满足 N 是 M 的两倍（即，N = 2 * M）。

更正式地，检查是否存在两个下标 i 和 j 满足：

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

示例 1：

输入：arr = [10,2,5,3]
输出：true
解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
示例 2：

输入：arr = [7,1,14,11]
输出：true
解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
示例 3：

输入：arr = [3,1,7,11]
输出：false
解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。

* */
public class solution_1346 {
    public boolean checkIfExist(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(list.contains(arr[i]*2) == true)
            {
                return true;
            }
            else if(arr[i] %2 == 0 && list.contains(arr[i] /2) == true)
            {
                return true;
            }else if(list.contains(arr[i]) == false)
                list.add(arr[i]);
        }
        return false;
    }
}
