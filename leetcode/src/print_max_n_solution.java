import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: print_max_n_solution
 * @Author: EdwardX
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
 * @Date: 2020/10/10 8:12
 * @Version: 1.0
 */
public class print_max_n_solution {
    public int[] printNumbers(int n) {
        int[] result = new int[(int)Math.pow(10,n)-1];
        for (int i = 1; i < Math.pow(10,n); i++) {
                result[i-1] = i;
        }
        return result;
    }
}
