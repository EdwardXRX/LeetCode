package easy;

import java.util.*;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: matrix_cells_in_distance_order_solution
 * @Author: EdwardX
 * @Description: 1030. 距离顺序排列矩阵单元格
 * @Date: 2020/11/17 7:55
 * @Version: 1.0
 */
/*
* 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

 

示例 1：

输入：R = 1, C = 2, r0 = 0, c0 = 0
输出：[[0,0],[0,1]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
示例 2：

输入：R = 2, C = 2, r0 = 0, c0 = 1
输出：[[0,1],[0,0],[1,1],[1,0]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
示例 3：

输入：R = 2, C = 3, r0 = 1, c0 = 2
输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。

*/
public class matrix_cells_in_distance_order_solution {
    public static void main(String[] args) {
        treemap_sort_by_Value(3,3,0,0);
    }
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        //答案集
        int[][] result = new int[R * C][2];
        //将String作为key存入
        //将曼哈顿距离以value存入
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                StringBuffer str = new StringBuffer();
                str.append(String.valueOf(i));
                str.append('#');
                str.append(String.valueOf(j));
                int length = Math.abs(i-r0)+Math.abs(j-c0);
                map.put(str.toString(),length);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int index = 0;
        for (Map.Entry<String, Integer> entry : list) {
            /*System.out.println(entry.getKey() + "=" + entry.getValue());*/

            String mylm = entry.getKey();
            String a[] = mylm.split("#");
            int i = Integer.valueOf(a[0]);
            int j = Integer.valueOf(a[1]);
            result[index][0] = i;
            result[index][1] = j;
            index++;

        }
        return result;

    }

    public static Map<String,Integer> treemap_sort_by_Value(int R,int C,int r0, int c0)
    {
        //将二维数组作为key存入
        //将曼哈顿距离以value存入
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                StringBuffer str = new StringBuffer();
                str.append(String.valueOf(i));
                str.append('#');
                str.append(String.valueOf(j));
                int length = Math.abs(i-r0)+Math.abs(j-c0);
                map.put(str.toString(),length);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        return map;




    }
}
