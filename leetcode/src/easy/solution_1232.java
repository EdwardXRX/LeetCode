package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1232
 * @Author: EdwardX
 * @Description: 1232. 缀点成线
 * @Date: 2021/1/17 21:27
 * @Version: 1.0
 */
/*
在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

*/
public class solution_1232 {
    public boolean checkStraightLine(int[][] cs) {
        // (y1 - y0)/(x1 - x0) == (yi - y0)/(xi - x0)
        // (y1 - y0)*(xi - x0) == (x1 - x0)*(yi - y0)
        for (int i = 2; i < cs.length; i++) {
            if ((cs[1][1] - cs[0][1]) * (cs[i][0] - cs[0][0]) != (cs[1][0] - cs[0][0]) * (cs[i][1] - cs[0][1])) return false;
        }
        return true;
    }



}
