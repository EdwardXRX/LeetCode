package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: next_permutation_solution
 * @Author: EdwardX
 * @Description: 31. 下一个排列
 * @Date: 2020/11/10 8:49
 * @Version: 1.0
 */

/*
* 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
public class next_permutation_solution {
    public static void nextPermutation(int[] nums) {
        //设index初始值为-1。
        //方便进行某些信息的获取
        //正常情况下，index如果在for里面进行了if操作，不可能还会-1，最小都是0
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {

            //从后往前找，找到第一个前面比后面一个数字小的地方
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        System.out.println("此时的index为："+ index);


        //当前情况说明，已经到达了所有数字排序出来得最大值了
        //直接从头到尾进行排序
        //从小到大排序，找到排序得最小值
        if (index == -1) {
            //不进行操作

        }
        //当前情况说明并未达到最大值
        //需要在当前得索引位后面得所有数字当中
        //找到一个比自己大，但是是后面数字中最小得数字进行交换
        else {
            //定义一个变量
            //去找最小的值的索引位置
            //定义一个变量进行数值的比较
            //下面两个变量，初始值都设置为index后的那个值及其索引
            int min = nums[index + 1];
            System.out.println("此时的min："+min);
            int min_index = index + 1;
            System.out.println("此时的min_index："+min_index);


            for (int i = min_index; i < nums.length; i++) {
                //首先要判断是否是大于index索引位置的那个值
                //如果都比这个值小，就没必要比较了
                if (nums[i] > nums[index]) {
                    //不断更新最小值及其下标
                    if (nums[i] < min) {
                        min = nums[i];
                        min_index = i;
                    }//内层if结束
                }//外层if结束
            }//for结束

            System.out.println("此时的min："+min);
            System.out.println("此时的min_index："+min_index);


            //出了for循环。也就是找到了在index之后，然后比其值大，后面里面的最小的索引
            //并且是一定会有的
            //进行交换操作
            {
                int temp = nums[index];
                nums[index] = nums[min_index];
                nums[min_index] = temp;
            }

        }
        //交换结束之后
        //index之后的所有值，按照从小到大排序
        quickSort(nums, index + 1, nums.length - 1);

    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        //不符合条件了
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
                int ttt = arr[i];
                arr[i] = arr[j];
                arr[j] = ttt;
            }

        }
        arr[low] = arr[i];//#或 arr[low] = arr[j];
        arr[i] = temp;//#或 arr[j] = temp;

        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,8,5,4,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
