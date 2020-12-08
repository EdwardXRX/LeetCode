import java.util.*;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: Main
 * @Author: EdwardX
 * @Description: main method
 * @Date: 2020/9/23 10:14
 * @Version: 1.0
 */

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7,8,  8};
        ArrayList<Integer> list = new ArrayList<>();
        int max = 1, current = 1;

        for (int i = 0; i < array.length - 1; i++) {
            //如果当前元素和后面元素相等，进行操作
            if (array[i] == array[i + 1]) {
                current++;

            }
            //这里是前后元素不相等
            else {
                current = 1;

                //在这里主要是为了数组的最后一个元素进行操作
                if(i  == array.length-2)
                {
                        if(max == 1)
                            list.add(array[array.length-1]);
                }
            }

            //判断当前的最长和我们的最长的大小的比值
            if (current == max) {
                list.add(array[i]);
            } else if (current >= max) {
                list.clear();
                list.add(array[i]);
                max = current;
            }
        }
        //将列表打印到数组中
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
            System.out.println(result[i]);
        }
    }
}
