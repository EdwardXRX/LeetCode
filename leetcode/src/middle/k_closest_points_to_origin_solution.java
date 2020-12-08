package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: k_closest_points_to_origin_solution
 * @Author: EdwardX
 * @Description: 973. 最接近原点的 K 个点
 * @Date: 2020/11/9 8:10
 * @Version: 1.0
 */
public class k_closest_points_to_origin_solution {
    public int[][] kClosest(int[][] points, int K) {

        //points 就是一个n行两列得二维数组

        //用map存储符合条件得坐标位置
        //key代表序号
        //value代表数组得横坐标。也就是第一维的数字
        Map<Integer,Integer> map = new HashMap<>();


        for (int i = 0; i < K; i++) {

            //下面两个变量，来记住当前循环最近得那个横纵坐标
            int index_xxx = 0;

            //用来记录距离
            double length=999999999;

            //下面得双重循环，为了找到最近得值
            for (int xxx = 0; xxx < points.length; xxx++) {
                //判断如果当前得直线距离比当前最小值还小，那就更新length
                //同时也要确定当前得map中不存在这个索引
                if(Math.sqrt(points[xxx][0]*points[xxx][0] +points[xxx][1]*points[xxx][1]) < length && map.containsValue(xxx) == false)
                {

                    //更新最小距离
                    length=Math.sqrt(points[xxx][0]*points[xxx][0] +points[xxx][1]*points[xxx][1]);
                    //记录下来索引
                    index_xxx = xxx;
                }
            }
            map.put(i,index_xxx);
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i][0] = points[map.get(i)][0];
            result[i][1] = points[map.get(i)][1];
        }
        return result;

    }
}
