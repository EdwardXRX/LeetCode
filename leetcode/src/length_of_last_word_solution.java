/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: length_of_last_word_solution
 * @Author: EdwardX
 * @Description: 58
 * @Date: 2020/9/25 8:14
 * @Version: 1.0
 */
public class length_of_last_word_solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        if (s == null)
            return 0;
        int len = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                len++;
            else
                break;
        }

        return len;

    }
}
