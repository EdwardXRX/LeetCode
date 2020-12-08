package leetcode;

public class implement_strstr_solution {

    public static void main(String[] args) {
        

    }


    public static int strStr(String haystack, String needle) {

        if (haystack == null && needle != null)
            return -1;
        else if(needle == null)
            return 0;

            return haystack.indexOf(needle);
    }





    }

