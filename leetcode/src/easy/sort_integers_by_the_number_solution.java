package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: sort_integers_by_the_number_solution
 * @Author: EdwardX
 * @Description: 1356. 根据数字二进制下 1 的数目排序
 * @Date: 2020/11/6 8:01
 * @Version: 1.0
 */
public class sort_integers_by_the_number_solution {
    public static void main(String[] args) {
        int[] arr = {3,6,5};
        int[] m = new int[11];
         m= sortByBits(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(m[i]);
        }
    }
    public static int[] sortByBits(int[] arr) {
        //若为空，则直接返回空
        if (arr.length == 0)
            return null;
        //先排序，防止后面因为相同个数的1导致乱序
        Arrays.sort(arr);
        //冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(getInt(arr[j]) > getInt(arr[j+1]))
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int getInt(int num)
    {
        int count=0;
        while (num!=0)
        {
            if(num%2 ==1)
                count++;
            num/=2;
        }
        return count;
    }
}
