package test;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: test
 * @ClassName: Main
 * @Author: EdwardX
 * @Description: for once again
 * @Date: 2020/9/27 10:42
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {








      /*  String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);
        System.out.println(s3 == s4);*/


    }

    public static String getNum(String a, String b) {
        StringBuffer str = new StringBuffer();
        int max = Math.max(a.length(), b.length()), current = 0;
        for (int i = 0; i < max; i++) {
            current += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            current += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            str.append((char) (current % 2 + '0'));
            current /=2;
        }

        if(current >0)
            str.append('1');

        return str.reverse().toString();
    }


}
