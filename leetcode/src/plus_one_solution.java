/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: plus_one_solution
 * @Author: EdwardX
 * @Description:
 * @Date: 2020/9/29 19:27
 * @Version: 1.0
 */
public class plus_one_solution {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9, 9, 9};
        nums = plusOne(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        digits = plus(digits, true, digits.length-1);
        return digits;

    }

    public static int[] plus(int[] digits, boolean flag, int i) {
        if (i == 0) {
            //数组扩容操作。
            if(flag == true) {
                if (digits[i] == 9) {
                    int[] dududu = new int[digits.length + 1];
                    dududu[0] = 1;
                    digits[i] = 0;
                    System.arraycopy(digits, 0, dududu, 1, digits.length);
                    return dududu;
                }
                else
                {
                    digits[i] += 1;
                    return digits;
                }
            }
            return digits;
        }

        if (flag == true) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                digits = plus(digits, false, i-1);
            } else {
                digits[i] = 0;
                digits = plus(digits, true, i-1);
            }
        } else {
            digits = plus(digits, false, i-1);
        }

        return digits;


    }
}
