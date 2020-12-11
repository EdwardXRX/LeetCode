package middle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: dota2_senate_slotion
 * @Author: EdwardX
 * @Description: 649. Dota2 参议院
 * @Date: 2020/12/11 8:32
 * @Version: 1.0
 */

/*
示例 1：

输入："RD"
输出："Radiant"
解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
示例 2：

输入："RDD"
输出："Dire"
解释：
第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利

*/
public class dota2_senate_slotion {

    public static String predictPartyVictory(String senate) {

        StringBuffer stringBuffer = new StringBuffer(senate);

        //三次循环就可以解决
        for (int j = 0; j < 3; j++) {


            //要注意，每个玩家最聪明，就代表：
            //一定是先把没有发言的干掉
            //再考虑前面的
            //这才是最聪明的玩家，默认每个玩家都是最聪明的。
            //所以找到消灭目标，一定是从自己位置往后找，如果没有，再考虑前面的
            for (int i = 0; i < stringBuffer.length(); i++) {
                System.out.println("i:"+i);
                if (stringBuffer.charAt(i) == 'R') {

                    int m = getChar(stringBuffer.toString(),i,'D');

                    if(m == -1)
                    {
                        m = stringBuffer.indexOf("D");
                    }

                    System.out.println("m:"+m);
                    if (m != -1) {
                        stringBuffer.replace(m,m+1,"X");
                    } else {
                        System.out.println("111");
                        return "Radiant";
                    }
                } else if (stringBuffer.charAt(i) == 'D') {

                    int m = getChar(stringBuffer.toString(),i,'R');

                    if(m == -1)
                    {
                        m = stringBuffer.indexOf("R");
                    }

                    System.out.println("m:"+m);
                    if (m != -1) {
                        stringBuffer.replace(m,m+1,"X");
                    } else {
                        return "Dire";
                    }
                }
                System.out.println("i:"+i);
                System.out.println("字符串"+stringBuffer.toString());
            }
            stringBuffer = new StringBuffer(stringBuffer.toString().replace("X","").trim());
            System.out.println(stringBuffer.toString());
        }
        return "Dire";
    }

    public static int getChar(String str,int startorend,Character target)
    {
            for (int i = startorend+1; i < str.length(); i++) {
                if(str.charAt(i) == target)
                    return i;
            }
        return -1;
    }



    public static void main(String[] args) {
        String str = "RRDDRDRDRDRDRDRDRDRDRDRDDDRDRDRDRDRDRDRDDDRDRDRDRDRDRDRDRDRDRDRRRRDRDDDDRDRDRDRDD";

        StringBuffer stringBuffer = new StringBuffer(str);

        System.out.println(stringBuffer.indexOf("X"));

        System.out.println(predictPartyVictory(str));






    }

}
