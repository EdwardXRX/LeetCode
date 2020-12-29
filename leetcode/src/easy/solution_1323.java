package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_1323
 * @Author: EdwardX
 * @Description: 1323. 6 和 9 组成的最大数字
 * @Date: 2020/12/29 9:29
 * @Version: 1.0
 */
public class solution_1323 {
    public int maximum69Number (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6","9"));
    }
}
