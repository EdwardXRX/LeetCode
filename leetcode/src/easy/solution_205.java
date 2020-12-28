package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_205
 * @Author: EdwardX
 * @Description: 205. 同构字符串
 * @Date: 2020/12/27 19:03
 * @Version: 1.0
 */
public class solution_205 {

    public boolean isIsomorphic(String s, String t) {


        for (int i = 0; i < s.length(); i++) {
            t= t.replace(t.charAt(i),s.charAt(i));
        }
        System.out.println(t);

        if(t.equals(s))
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        String t= "123456";
        t = t.replace('1','2');
        System.out.println(t);

    }
}
