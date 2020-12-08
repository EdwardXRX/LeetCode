package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: test
 * @Author: EdwardX
 * @Description: 长安
 * @Date: 2020/10/21 15:01
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(list.size()-1));
        list.remove(list.size()-1);
        System.out.println(list.get(list.size()-1));


    }

    public static boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed))
            return true;
        else if((name == null && typed != null) ||(name != null && typed == null) )
            return false;


        boolean flag = true;

        for (int i = 0,j = 0; i < name.length()  ; i++) {

            if(j>=typed.length())
            {
                flag = false;
                break;
            }
            System.out.println("当前循环至："+ i);
            if(name.charAt(i) == typed.charAt(j))
            {

                //当前情况就是结点没到最后一个并且当前i结点和后面结点不相等
                //让j指针移到下一个元素即可
                if(i <= name.length() -2 && name.charAt(i) != name.charAt(i +1) )
                {
                    System.out.println(j);
                    while (j < typed.length() && typed.charAt(j) == name.charAt(i))
                    {
                        j++;
                    }
                    System.out.println("当前情况就是结点没到最后一个并且当前i结点和后面结点不相等"+j);
                }
                //当前情况就是结点没到最后一个且当前i结点和后面结点相等
                else if(i <= name.length() -2 && name.charAt(i) == name.charAt(i +1) )
                {
                    j++;
                    System.out.println("当前情况就是结点没到最后一个且当前i结点和后面结点相等"+j);
                }
                //当前情况就是结点已经走到了最后了
                else if( i == name.length() -1 && j<= typed.length()-1)
                {
                    System.out.println("---------------");
                    for (int y = j; y < typed.length(); y++) {
                        if(name.charAt(i) != typed.charAt(y)) {
                            flag = false;
                            break;
                        }
                    }
                }
                else if (j >= typed.length())
                {
                    flag = false;
                    break;
                }
            }
            else
            {
                flag =false;
                break;
            }
        }



        return flag;
    }

}
