/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: find_numbers_with_even_number_of_digits_solution
 * @Author: EdwardX
 * @Description: 1295. 统计位数为偶数的数字
 * @Date: 2020/10/20 11:23
 * @Version: 1.0
 */
public class find_numbers_with_even_number_of_digits_solution {
    public int findNumbers(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            String test = String.valueOf(nums[i]);
            if(test.length() %2 == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 100;
        String test = String.valueOf(num);
        System.out.println(test.length());
    }
}
