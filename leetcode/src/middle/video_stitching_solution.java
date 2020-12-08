package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: video_stitching_solution
 * @Author: EdwardX
 * @Description: 1024. 视频拼接
 * @Date: 2020/10/24 7:55
 * @Version: 1.0
 */

/*
* 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。
* 这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
* 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
* 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

*/


/*
* 输入：clips =
* [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],
* [4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]],
* T = 9
输出：3
解释：
我们选取片段 [0,4], [4,7] 和 [6,9] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/video-stitching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class video_stitching_solution {

    static List<List<Integer>> lists = new ArrayList<>();
    public static  int videoStitching(int[][] clips, int T) {
        dfs(clips, T, new ArrayList<>(),0);

        int min = 99999;
        if(lists.size() == 0)
            return -1;
        else
        {
            for (List<Integer> list : lists) {
                if (list.size() < min)
                    min = list.size();
            }
        }

        return min;
    }

    public  static  void dfs(int[][] clips,int T,List<Integer> list,int right)
    {
        //递归出口
        if(right >= T)
        {
            lists.add(new ArrayList<>(list));
            return;
        }

        //for循环嵌套递归
        for (int i = 0; i < clips.length; i++) {
            if(clips[i][0] <= right && clips[i][1] > right)
            {
                list.add(1);
                dfs(clips,T,list,clips[i][1]);
                list.remove(list.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        int[][] clips = {{0,5},{1,6},{2,7},{3,8},{4,9},{5,10},{6,11},{7,12},{8,13},{9,14},{10,15},{11,16},{12,17},{13,18},{14,19},{15,20},{16,21},{17,22},{18,23},{19,24},{20,25},{21,26},{22,27},{23,28},{24,29},{25,30},{26,31},{27,32},{28,33},{29,34},{30,35},{31,36},{32,37},{33,38},{34,39},{35,40},{36,41},{37,42},{38,43},{39,44},{40,45},{41,46},{42,47},{43,48},{44,49},{45,50},{46,51},{47,52},{48,53},{49,54}}
                ;
        System.out.println(videoStitching(clips,50));
    }


}
