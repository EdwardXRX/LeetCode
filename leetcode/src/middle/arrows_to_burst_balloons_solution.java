package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: arrows_to_burst_balloons_solution
 * @Author: EdwardX
 * @Description: 452. 用最少数量的箭引爆气球
 * @Date: 2020/11/23 9:02
 * @Version: 1.0
 */

/*
* 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。

 
示例 1：

输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
示例 2：

输入：points = [[1,2],[3,4],[5,6],[7,8]]
输出：4
示例 3：

输入：points = [[1,2],[2,3],[3,4],[4,5]]
输出：2
示例 4：

输入：points = [[1,2]]
输出：1
示例 5：

输入：points = [[2,3],[2,3]]
输出：1
*/

public class arrows_to_burst_balloons_solution {

    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });


        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            min = Math.max(min,points[i][0]);
            max = Math.min(max,points[i][1]);
            if(min>max){
                min = points[i][0];
                max = points[i][1];
                ans++;
            }
        }
        return ans;
    }
    public int findMinArrowShots(int[][] points) {

        //如果1个气球或者0个气球
        //直接返回气球数量，气球数量就是箭数量
        if (points.length == 1)
            return 1;

        if (points.length == 0)
            return 0;

        //🗡的总数初始为气球总数量
        //反过来减就行
        int arrows = points.length;

        for (int i = 0; i < points.length; i++) {

            for (int j = i + 1; j < points.length; j++) {

                //如果本气球算是有效气球
                //则进行操作
                if (points[j][0] != points[j][1]) {
                    //有交集
                    if ((points[j][0] <= points[i][1] && points[j][0] >= points[i][0]) || (points[j][1] >= points[i][0] && points[j][1] <= points[i][1])
                            || (points[j][0] <= points[i][0] && points[j][1] >= points[i][1])) {
                        arrows--;
                        //更新交集
                        points[i][0] = Math.max(points[i][0], points[j][0]);
                        points[i][1] = Math.min(points[i][1], points[j][1]);

                        //使计算过的设为0，0
                        points[j][0] = 0;
                        points[j][1] = 0;
                    }
                }
            }
        }
        return arrows;
    }
}
