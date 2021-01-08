package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_547
 * @Author: EdwardX
 * @Description: 547. 省份数量
 * @Date: 2021/1/7 9:03
 * @Version: 1.0
 */
/*
有 n 个城市，其中一些彼此相连，另一些没有相连。

如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，

其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，

而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。


*/
public class solution_547 {

    public static int findCircleNum(int[][] isConnected) {
        //定义一个总的数组，来记录是否已经查询
        int[] array = new int[isConnected.length];
        //省份数量
        int province = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 0) {
                province++;
                dfs(isConnected, j, array);
            }
        }
        return province;
    }

    public static void dfs(int[][] isConnected, int i, int[] array) {
        array[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            //发现岛屿相连
            if (isConnected[i][j] == 1 && array[j] == 0) {
                //说明当前省份中，没有这个省份，就添加进这个省份中
                dfs(isConnected, j, array);
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(array));
    }
}
