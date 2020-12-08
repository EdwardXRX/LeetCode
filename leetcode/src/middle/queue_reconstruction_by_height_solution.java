package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: queue_reconstruction_by_height_solution
 * @Author: EdwardX
 * @Description: 406. 根据身高重建队列
 * @Date: 2020/11/16 9:43
 * @Version: 1.0
 */
public class queue_reconstruction_by_height_solution {
    public void reconstructQueue(int[][] people) {
        //新的一个
        int[][] new_people = new int[people.length][2];




    }

    public void sort_high_to_low(int[][] people) {

    }

    public static void quick(int[][] arr, int low, int high) {
        int i, j, temp;
        if (low > high)
            return;
        i = low;//左边哨兵的索引
        j = high;//右边哨兵的索引

        temp = arr[low][0];

        while (i < j) {
            while (temp <= arr[j][0] && i < j) {
                j--;
            }
            while (temp >= arr[i][0] && i < j) {
                i++;
            }
            //交换操作
            if (i < j) {
                //#z、y 都是临时参数，用于存放 左右哨兵 所在位置的数据
                int one = arr[i][0];
                int two = arr[i][1];

                arr[i][0] = arr[j][0];
                arr[i][1] = arr[j][1];

                arr[j][0] = one;
                arr[j][1] = two;
            }
        }
        arr[low][0] = arr[i][0];//#或 arr[low] = arr[j];
        arr[i][0] = temp;//#或 arr[j] = temp;


/*#i=j
#这时  左半数组<(i或j所在索引的数)<右半数组
#也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
# 只要用相同的方法 分别处理  左右数组就可以了*/

        //递归调用左半数组
        quick(arr, low, j - 1);
        //递归调用右半数组
        quick(arr, j + 1, high);
    }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;//左边哨兵的索引
        j = high;//右边哨兵的索引
        //temp就是基准位
        temp = arr[low];//以最左边为  基准位

        while (i < j) {
            //先看右边，依次往左递减
           /* #先从右往左找一个小于 基准位的数
            #当右边的哨兵位置所在的数>基准位的数 时
            #继续从右往左找（同时 j 索引-1）
            #找到后会跳出 while循环*/
            while (temp <= arr[j] && i < j) {
                j--;
            }

            //再看左边，依次往右递增
            //#步骤和上面类似
            while (temp >= arr[i] && i < j) {
                i++;
            }

            //如果满足条件则交换
            if (i < j) {

                //#z、y 都是临时参数，用于存放 左右哨兵 所在位置的数据
                int z = arr[i];
                int y = arr[j];

                //# 左右哨兵 交换数据（互相持有对方的数据）
                arr[i] = y;
                arr[j] = z;

            }
        }


/*
#这时 跳出了 “while (i<j) {}” 循环
#说明 i=j 左右在同一位置*/
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];//#或 arr[low] = arr[j];
        arr[i] = temp;//#或 arr[j] = temp;


/*#i=j
#这时  左半数组<(i或j所在索引的数)<右半数组
#也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
# 只要用相同的方法 分别处理  左右数组就可以了*/

        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


}
