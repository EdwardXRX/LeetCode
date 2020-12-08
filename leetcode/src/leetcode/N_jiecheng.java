package leetcode;

import java.util.Scanner;

public class N_jiecheng {
    public static void main(String[] args) {

        System.out.println("请输入n的值");
        int n = new Scanner(System.in).nextInt();
        System.out.println(n_sum(n));

    }

    public static int n_sum(int n )
    {
        if(n==1||n==0)
            return 1;
        else
        {
            return n*n_sum(n-1);
        }
    }

}
