

public class Solution {

    public static boolean isPalindrome(int x) {
        if (x > 0) {
            int temp=0;
            int m = x;
            while(m!=0)
            {
                temp = temp*10 + m%10;
                m/=10;
            }

            if(temp==x)
                return true;

            }




         else if (x == 0)
            return true;
        else
            return false;

        return false;
    }


    public static void main(String[] args) {
        boolean m = isPalindrome(1322231);
        System.out.println(m);
    }


}