import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: find_mode_in_binary_search_tree_solution1
 * @Author: EdwardX
 * @Description: 501_2
 * @Date: 2020/9/24 9:51
 * @Version: 1.0
 */
public class find_mode_in_binary_search_tree_solution1 {


    //找二叉树的结点的众数
    public int[] findMode(TreeNode root) {
        int i = 0;
        //获取树的结点总数
        i = size(root);

        //新建一个长度为树的结点总数的数组
        int[] array = new int[i];

        //将结点的数值打印到数组中
        printToArray(array, root);


        //打印数组。检查是否将树中的结点打印进去了
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

        //判断所有数组元素是不是都互不相等，如果互不相等，直接返回原数组；
        boolean check = true;
        for (int x = 0; x < array.length - 1; x++) {
            if (array[x] == array[x + 1]) {
                check = false;
            }
        }
        if (check == true)
            return array;


        //先找到有几个重复的数字，再根据重复的个数，创建一个数组
        Map<Integer, Integer> map = new HashMap<>();
        int num = 1;
        for (int m = 0; m < array.length - 1; m++) {
            if (map.containsKey(array[i]) == false) {
                map.put(array[i], 0);
            } else
                map.put(array[i], (map.get(array[i]) + 1));
        }




        return array;


    }


    //全局变量i，用来递归时候给数组赋值
    public static int i = 0;

    //将二叉树的结点的数值输入到数组
    public void printToArray(int[] array, TreeNode treeNode) {
        if (treeNode != null) {
            printToArray(array, treeNode.left);

            array[i] = treeNode.val;
            i++;
            //操作
            printToArray(array, treeNode.right);

        }
    }

    //获取二叉树的结点总数
    public int size(TreeNode root) {
        if (root == null) return 0;
        else return 1 + size(root.left) + size(root.right);
    }


}
