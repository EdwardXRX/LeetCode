package middle;

import study.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_684
 * @Author: EdwardX
 * @Description: 684. 冗余连接
 * @Date: 2021/1/13 9:53
 * @Version: 1.0
 */

/*
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。

附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。

每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。

如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：

输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
注意:

输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
更新(2017-09-26):
我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。

*/
public class solution_684 {
    public static int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0 || edges == null)
            return new int[0];
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] >= max)
                max = edges[i][0];
            if (edges[i][1] >= max)
                max = edges[i][1];
        }
        int[] array = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {

            //如果两个是两个阵营，则变为一个队伍
            if (array[edges[i][0]] != array[edges[i][1]]) {
                int m = array[edges[i][1]];
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == m) {
                        array[j] = array[edges[i][0]];
                    }
                }
            } else if (array[edges[i][0]] == array[edges[i][1]]) {
                //说明两个人已经在一个组内了。则将这两个都添加进去
                if (list.contains(edges[i][0]) == false)
                    list.add(edges[i][0]);

                if (list.contains(edges[i][1]) == false)
                    list.add(edges[i][1]);
            }

            for (int m = 0; m < array.length; m++) {
                System.out.print("--" + m + "--");
            }
            System.out.println("");
            for (int x = 0; x < array.length; x++) {
                System.out.print("--" + array[x] + "--");
            }
            System.out.println("");

            System.out.println("-----------------------------------------------");

        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;


    }

    public static void main(String[] args) {
        int[][] array = {{3, 7}, {1, 4}, {2, 8}, {1, 6}, {7, 9}, {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}};
        int[] result = findRedundantConnection1(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] findRedundantConnection1(int[][] edges) {
        if (edges.length == 0 || edges == null)
            return new int[0];
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] >= max)
                max = edges[i][0];
            if (edges[i][1] >= max)
                max = edges[i][1];
        }

        int[] roots = new int[max + 1];
        int[] ranks = new int[max + 1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (find(roots[edges[i][0]], roots) != find(roots[edges[i][1]], roots)) {
                union(edges[i][0], edges[i][1], roots,ranks);
            } else if (find(roots[edges[i][0]], roots) == find(roots[edges[i][1]], roots)) {
                if (list.contains(edges[i][0]) == false)
                    list.add(edges[i][0]);

                if (list.contains(edges[i][1]) == false)
                    list.add(edges[i][1]);
            }

        }
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;


    }

    public static int find(int i, int[] roots) {
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i], roots);
    }

    public static void union(int i, int j, int[] roots,int[] ranks) {
        int x = find(i, roots);
        int y = find(j, roots);

        if (ranks[x] <= ranks[y])
            roots[x] = y;
        else
            roots[y] = x;
        if (ranks[x] == ranks[y] && x != y)
            ranks[y]++;
    }

}


class UF {
    int[] roots;
    int size; // 集合数量

    public UF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            roots[pRoot] = qRoot;
            size--;
        }
    }
}




