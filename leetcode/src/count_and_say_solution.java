
/**
* @author ED夏
* @version 1.0
* @since 1.8
*
 **/



public class count_and_say_solution {
    public static void main(String[] args) {

        System.out.println(countAndSay(5));


    }


    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        else
        {
            String str = "1";
            for (int i = 0; i < n-1; i++) {
                str=test(str);
            }
            return str;
        }
        


    }



    public static String test(String str)
    {
        String xx = "";
        if(str.length()==1)
            return xx.concat("1").concat(str);
        String temp = "";
        int len = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                len++;
                if(i == str.length()-2)
                {
                    temp = temp.concat(String.valueOf(len) ).concat(Character.toString(str.charAt(i)));
                }
            }
            else
            {

                temp = temp.concat(String.valueOf(len) ).concat(Character.toString(str.charAt(i)));

                if(i == str.length()-2)
                {
                    temp = temp.concat("1").concat(Character.toString(str.charAt(str.length()-1)));
                }
                len=1;
            }
        }
        return temp;

        }


    }

