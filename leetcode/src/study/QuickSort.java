package study;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: study
 * @ClassName: QuickSort
 * @Author: EdwardX
 * @Description: 快速排序
 * @Date: 2020/11/9 10:15
 * @Version: 1.0
 */
public class QuickSort {

    //arr 需要排序的数组
// low 开始时最左边的索引=0
// high 开始时最右边的索引=arr.length-1
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


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    /**
     * 快排从大到小
     */
    private static Integer[] quickSortBig2Small(Integer[] arr, int low, int high) {

        // 如果开始点和结束点没有重叠的时候，也就是指针没有执行到结尾
        if (low < high) {

            // 重新获取中间点
            int mid = getIndexFromBig2Small(arr, low, high);
            quickSortBig2Small(arr, low, mid - 1);
            quickSortBig2Small(arr, mid + 1, high);
        }
        return arr;
    }

    /**
     * 快排从小到大
     */
    private static Integer[] quickSortSmall2Big(Integer[] arr, int low, int high) {

        // 如果开始点和结束点没有重叠的时候，也就是指针没有执行到结尾
        if (low < high) {

            // 重新获取中间点
            int mid = getIndexFromSmall2Big(arr, low, high);
            quickSortSmall2Big(arr, low, mid - 1);
            quickSortSmall2Big(arr, mid + 1, high);
        }
        return arr;
    }

    /**
     * 交换数组元素
     */
    private static void swap(Integer[] arr, int low, int high) {

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    /**
     * 获取中间值（从大到小）
     */
    private static int getIndexFromBig2Small(Integer[] arr, int low, int high) {

        // 中值作为中点
        int index = (low + high) / 2;

        int midNum = arr[index];

        // 无论取的值是哪一个，都应该将其放在最后面
        swap(arr, index, high);

        while (low < high) {

            // 左侧值大于或者等于右侧值时候，只需要移动指针即可，不需要交换（ 注意 =，没有会陷入死循环）
            while (low < high && arr[low] >= midNum)
                low++;
            swap(arr, low, high);

            // 右侧值小于或者等于右侧值时候，只需要移动指针即可，不需要交换
            while (low < high && arr[high] <= midNum)
                high--;
            swap(arr, low, high);
        }
        return high;
    }

    /**
     * 获取中间值（从小到大）
     */
    private static int getIndexFromSmall2Big(Integer[] arr, int low, int high) {

        // 中值作为中点
        int index = (low + high) / 2;

        int midNum = arr[index];

        // 无论取的值是哪一个，都应该将其放在最后面
        swap(arr, index, high);

        while (low < high) {

            // 左侧值小于或者等于右侧值时候，只需要移动指针即可，不需要交换（ 注意 =，没有会陷入死循环）
            while (low < high && arr[low] <= midNum)
                low++;
            swap(arr, low, high);

            // 右侧值小大于于或者等于右侧值时候，只需要移动指针即可，不需要交换
            while (low < high && arr[high] >= midNum)
                high--;
            swap(arr, low, high);
        }
        return high;
    }
}