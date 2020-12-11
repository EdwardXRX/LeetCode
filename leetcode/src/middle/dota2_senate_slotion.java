package middle;

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
    public String predictPartyVictory(String senate) {

        return "Radiant";

    }
}
