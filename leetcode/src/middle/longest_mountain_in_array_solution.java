package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: longest_mountain_in_array_solution
 * @Author: EdwardX
 * @Description: 845. 数组中的最长山脉
 * @Date: 2020/10/25 18:33
 * @Version: 1.0
 */

/*
* 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

B.length >= 3
存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
（注意：B 可以是 A 的任意子数组，包括整个数组 A。）

给出一个整数数组 A，返回最长 “山脉” 的长度。

如果不含有 “山脉” 则返回 0。

 

示例 1：
输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。

示例 2：
输入：[2,2,2]
输出：0
解释：不含 “山脉”。
 

提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000
*/
public class longest_mountain_in_array_solution {
    public static void main(String[] args) {
        int[] test = {2,0,2,0};
        System.out.println(longestMountain(test));
    }


    public static int longestMountain(int[] A) {

        //如果元素个数直接小于3，那就直接返回0.
        if (A.length < 3)
            return 0;

        //记录上一个元素
        int pre = A[0];

        //记录最后返回值，最长的山脉
        int max = 0;

        //记录某一山脉长度
        int count = 1;

        //用来躲避平原直接下降，没有上坡过程
        int ccccccccccccc =-1;


        //用来记录转折
        //如果是true，就说明是在上坡的过程
        //如果是false，就说明已经在下坡勒
        boolean flag = true;

        //用来判断是否有上坡过程
        //如果就是单纯的下坡，那就不行
        //怎么判断：
        //一旦一个数字比之前的大，就一定出现了转折
        //只要转折，就返回正常的max，否则就直接返回0
        boolean ssss = true;

        for (int i = 1; i < A.length; i++) {

            //如果是true，那就开始上坡
            if (flag) {

                //当前数字大于前面的数字
                //说明是正常的上坡，开始计数了得；
                if (A[i] > pre) {
                    ccccccccccccc = 1;
                    ssss = false;
                    pre = A[i];
                    count++;
                }
                //当前数字和前面的数字相等，因为这是上坡过程，所以count又得重新计数
                //而且此时的count无效的
                //不需要转下坡
                else if (A[i] == pre) {
                    ccccccccccccc =0;
                    pre = A[i];
                    count = 1;
                }
                //否则就是当前数字比之前的小了，继续计数
                //而且flag改为false。
                else {
                    pre = A[i];

                    //判断是不是山顶有一段平原期
                    if(ccccccccccccc == 0)
                    {
                        count =1;
                    }
                    else {
                        count++;
                        if (count > max) {
                            max = count;
                        }

                        flag = false;
                    }
                }
            }
            //否则就是下坡
            //在下坡情况，可能就会遇到重新上坡的情况。也会遇到比较最大山脉的情况
            else {
                //当前情况，就说明在正常下坡
                if (pre > A[i]) {
                    pre = A[i];
                    count++;
                    //在下坡过程中，需要不断确定count是否超出max
                    if (count > max) {
                        max = count;
                    }
                }
                //当前数字和前面的数字相等
                //说明当前的山脉已经结束，需要进行和max的比较
                //需要将flag改为true，因为转为上坡了
                else if (pre == A[i]) {
                    pre = A[i];
                    //当前山脉长度和最长山脉长度比较
                    if (count > max)
                        max = count;

                    count = 1;
                    //转为上坡
                    flag = true;
                }
                //当前元素大于前面的元素，说明开始上坡了。
                //而当前元素和上一元素，这两个元素本身就构成了一个上坡的过程
                //所以count要设置为2；
                //还要转上坡
                //还要比较max
                else {
                    ssss = false;
                    pre = A[i];
                    //比较
                    if (count > max)
                        max = count;

                    count = 2;
                    //转为上坡
                    flag = true;
                }
            }
        }

        if(max<3)
            max =0;

        if(!ssss)
            return max;
        else
            return 0;

    }
}
