package easy;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: long_pressed_name_solution
 * @Author: EdwardX
 * @Description: 925. 长按键入
 * @Date: 2020/10/21 10:08
 * @Version: 1.0
 */
public class long_pressed_name_solution {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aalleeex";
        System.out.println(isLongPressedName(name,typed));

    }

    public static boolean isLongPressedName(String name, String typed) {

        boolean flag = true;
        for (int i = 0, j = 0; i < name.length(); i++) {

            //首先判断当前两个指针指向得元素是否匹配
            if (name.charAt(i) == typed.charAt(j)) {

                //如果当前元素相等，就要判断name中得当前元素和下一个元素是不是相等
                //如果相等，就两个指针同步向后移
                //如果不相等，那就让j指针指到相等元素得最后一个元素位置
                if(i != name.length()-1) {
                    if (name.charAt(i) != name.charAt(i + 1)) {
                        //将j指针指向重复元素得最后一个位置
                        while (typed.charAt(j + 1) == typed.charAt(j))
                            j++;
                        j++;
                        System.out.println(typed.charAt(j));
                    }
                    //当前情况，就是name中当前元素和后面得元素相同，所以需要两个指针同步进行移动
                    else {
                        j++;
                        continue;
                    }
                }
                else
                {
                    while (typed.charAt(j + 1) == typed.charAt(j))
                        j++;
                    if(j != typed.length())
                        flag = false;
                }
            }
            else
            {
                flag = false;
            }
        }
        return flag;

    }
}
