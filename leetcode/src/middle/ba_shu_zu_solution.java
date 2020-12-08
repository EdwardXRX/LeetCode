package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: ba_shu_zu_solution
 * @Author: EdwardX
 * @Description: 剑指 Offer 45. 把数组排成最小的数
 * @Date: 2020/10/27 16:12
 * @Version: 1.0
 */
public class ba_shu_zu_solution {

    public static void main(String[] args) {
            int[] nums = {3,30,34,5,9};
        System.out.println(minNumber(nums));

    }

    public static String minNumber(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if ((new StringBuffer(String.valueOf(nums[j]))).append(String.valueOf(nums[j+1])).toString().compareTo((new StringBuffer(String.valueOf(nums[j+1]))).append(String.valueOf(nums[j])).toString()) >= 0 ) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            stringBuffer.append(String.valueOf(nums[i]));
        }
        return stringBuffer.toString();
    }


}
