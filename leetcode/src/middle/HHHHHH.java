package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: HHHHHH
 * @Author: EdwardX
 * @Description: 专门将‘【】’转化为‘{}’
 * @Date: 2020/10/24 15:27
 * @Version: 1.0
 */
public class HHHHHH {
    public static void main(String[] args) {
        String m = "[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]";
        StringBuffer str = new StringBuffer(m);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '[')
            {
                str.setCharAt(i,'{');
            }
            if(str.charAt(i) == ']')
            {
                str.setCharAt(i,'}');
            }

        }
        System.out.println(str.toString());
        }
    }


