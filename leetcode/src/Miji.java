/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: Miji
 * @Author: EdwardX
 * @Description: 算法课需要的代码
 * @Date: 2020/9/23 17:18
 * @Version: 1.0
 */
public class Miji {

    public static void main(String[] args) {
        //模拟一个集合
        int[] original_set = {1, 2, 3};

        //获取该集合元素个数
        int length = original_set.length;

        //静态初始化一个数组，用装载所有解向量中的一个解向量
        int[] one_of_results = {0, 0, 0};

        System.out.println("求解结果：");

        //从0层开始深度遍历
        dfs(original_set, length, 0, one_of_results);
        //换行操作
        System.out.println("");
    }

    //打印结果集
    public static void PrintResult(int[] original_set, int n, int[] one_of_results) {

        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if (one_of_results[i] == 1) {
                System.out.print(" "+original_set[i]+" ");
            }
        }
        System.out.print("}");
        System.out.println("");
    }

    /**
     * @param original_set     原始集合
     * @param length           集合长度，用来给予上界
     * @param index            数组下标索引数字
     * @param one_of_results   一个解向量数组
     */
    public static void dfs(int[] original_set, int length, int index, int[] one_of_results) {
        if (index >= length)
            //打印结果
            PrintResult(original_set, length, one_of_results);
        else {
            //不选择a[i]
            one_of_results[index] = 0;
            dfs(original_set, length, index + 1, one_of_results);
            //选择a[i]
            one_of_results[index] = 1;
            dfs(original_set, length, index + 1, one_of_results);
        }
    }


}
