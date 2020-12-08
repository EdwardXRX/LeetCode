/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: reverse_words_in_a_string_iii_solution_1
 * @Author: EdwardX
 * @Description: 557. 反转字符串中的单词 III
 * @Date: 2020/10/13 20:01
 * @Version: 1.0
 */
public class reverse_words_in_a_string_iii_solution_1 {
    public static void main(String[] args) {
        String str = "sdfasd asdf asdf sdfsdf";

    }
    public  String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");

        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(new StringBuilder(strings[i]).reverse());
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

}
