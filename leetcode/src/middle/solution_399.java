package middle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_399
 * @Author: EdwardX
 * @Description: 399. 除法求值
 * @Date: 2021/1/6 8:48
 * @Version: 1.0
 */


/*
给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。

每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。

 

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

 

示例 1：

输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
条件：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
示例 2：

输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：

输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]
 

提示：

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj 由小写英文字母与数字组成


*/
public class solution_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //如果提示集合为空，说明答案全部是-1
        if (equations.size() == 0) {
            double[] result = new double[queries.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = -1.0;
            }
            return result;
        }

        //存放所有元素的集合，假设都没有给出明确数字，则自己定义
        Map<String, Double> numMap = new HashMap<>();

        //返回结果集
        double[] result = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            if (equations.get(i).get(0).equals(equations.get(i).get(1))) {
                if (!numMap.containsKey(equations.get(i).get(0))) {
                    numMap.put(equations.get(i).get(0), values[i]);
                }
            }
        }

        //如果不存在直接给出的答案，那我们就自己定义一个数为确定的数，通过这个数把所有答案给求出
        if (numMap.isEmpty()) {
            //将第一个数定义一个确定的数（100）
            numMap.put(equations.get(0).get(0), 100.0);
        }


        for (int j = 0; j < equations.size(); j++) {
            for (int i = 0; i < equations.size(); i++) {
                if (numMap.containsKey(equations.get(i).get(0)) == true && numMap.containsKey(equations.get(i).get(1)) == false) {
                    numMap.put(equations.get(i).get(1), numMap.get(equations.get(i).get(0)) / values[i]);
                } else if (numMap.containsKey(equations.get(i).get(1)) == true && numMap.containsKey(equations.get(i).get(0)) == false) {
                    numMap.put(equations.get(i).get(0), numMap.get(equations.get(i).get(1)) * values[i]);
                }
            }
        }




        numMap.put(equations.get(0).get(0), 100.0);

        for (int i = 0; i < equations.size(); i++) {
            for (int j = 0; j < equations.size(); j++) {


            }
        }


        return result;
    }

    public static void main(String[] args) {


    }


}
