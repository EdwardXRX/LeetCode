package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: remove_k_digits_solution
 * @Author: EdwardX
 * @Description: 402. 移掉K位数字
 * @Date: 2020/11/15 10:01
 * @Version: 1.0
 */
public class remove_k_digits_solution {
    public static void main(String[] args) {

    }

    public static String removeKdigits(String num, int k) {

        if(num.length() == k)
            return "0";

        if (k==0)
        {
            String s = removeZero(num);
            if(s == "" || s.length() == 0)
                return "0";
            else
                return s;
        }
        //方便取值
        StringBuffer stringBuffer = new StringBuffer(removeZero(num));
        for (int i = 0; i < k; i++) {
                stringBuffer = new StringBuffer(update_remove_k(stringBuffer.toString()));
        }
        return stringBuffer.toString();

    }

    //这个函数是找出当前数字，去除一个字符之后的最小值
    //返回值即是最小值
    public static String update_remove_k(String num)
    {
        //去除有效数字前的‘0’
        String number = removeZero(num);


        //如果去除0之后，就是啥都没有勒
        //直接返回0
        if(number.compareTo("") == 0 || number.length() == 0 || number == "" )
            return "0";

        //最小值
        StringBuffer min = new StringBuffer(number);

        for (int i = 0; i < number.length(); i++) {

            //获取除去当前i得字符串
            StringBuffer sss = new StringBuffer(num.substring(0,i));
            sss.append(num.substring(i+1,num.length()));
            //对去除之后的数字也进行去‘0’处理
            //防止在比较大小时候出现问题
            sss = new StringBuffer(removeZero(sss.toString()));

            //说明当前得数字大小是比min还小
            //那就更新min
            if( compare_str(sss.toString(),min.toString())<0)
            {
                //同理，经过去0处理（更新min）
                min = new StringBuffer(removeZero(sss.toString()));
            }
        }

        if(min.toString().compareTo("") == 0 || min.toString().length()==0)
            return "0";

        return min.toString();
    }

    public static String removeZero(String num)
    {
        int index =0;
        while (index<num.length())
        {
            if(num.charAt(index) == '0')
            {
                index++;
            }
            else
            {
                break;
            }
        }

        return num.substring(index,num.length());
    }

    public static int compare_str(String s1,String s2)
    {
        if(s1.length()>s2.length())
            return 1;
        else if(s1.length() == s2.length())
            return s1.compareTo(s2);
        else
            return -1;
    }
}
