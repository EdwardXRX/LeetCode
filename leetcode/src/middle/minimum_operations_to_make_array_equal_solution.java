package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: minimum_operations_to_make_array_equal_solution
 * @Author: EdwardX
 * @Description: 1551. 使数组中所有元素相等的最小操作数
 * @Date: 2020/10/17 8:07
 * @Version: 1.0
 */
public class minimum_operations_to_make_array_equal_solution {
    public int minOperations(int n) {
        int temp =0;
        for (int i = 0; i < n / 2; i++) {
            temp += n- (2*i +1 );
        }
        return temp;

    }
}
