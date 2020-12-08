package middle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: test
 * @Author: EdwardX
 * @Description:
 * @Date: 2020/9/25 11:13
 * @Version: 1.0
 */

public class test {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();


    public static void main(String[] args) {

        int[][] sss = {{4289383,51220269},{81692777,96329692},{57747793,81986128},{19885386,69645878},{96516649,186158070},{25202362,75692389},{83368690,85888749},{44897763,112411689},{65180540,105563966},{4089172,7544908}};


        for (int i = 0; i < sss.length; i++) {
            for (int j = 0; j < sss[0].length; j++) {
                sss[i][j] = sss[i][j] - 4000000;
                System.out.print(sss[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }

    }
    public static String removeZero(String num)
    {
        int index =0;
        while (index<num.length())
        {
            if(num.charAt(index) == '0')
            {
                index++;
            }
            else
            {
                break;
            }
        }

        return num.substring(index,num.length());
    }

    public void leaver(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (queue.isEmpty() != true) {
            Node temp = queue.remove();
            System.out.println("遍历当前结点");
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
    }

    public int jiecheng(int n) {
        if (n == 1) {
            return n = 1;
        } else {
            return n * jiecheng(n - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (num == null || num.length == 0)
            return list;
        Arrays.sort(num);
        dfs(num, 0, target, ls);
        return list;

    }

    private static void dfs(int[] arr, int index, int sum, ArrayList<Integer> ls) {
        if (sum < 0)
            return;
        if (sum == 0) {
            if (!list.contains(ls))
                list.add(new ArrayList<>(ls));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            ls.add(arr[i]);
            //此处从i+1开始
            dfs(arr, i + 1, sum - arr[i], ls);
            ls.remove(ls.size() - 1);
        }

    }
}

