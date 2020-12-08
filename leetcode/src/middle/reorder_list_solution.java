package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: reorder_list_solution
 * @Author: EdwardX
 * @Description: 143. 重排链表
 * @Date: 2020/10/20 8:05
 * @Version: 1.0
 */
public class reorder_list_solution {
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int num = 0;
        while (head != null) {
            num++;
            map.put(num, head);
            head = head.next;
        }
        System.out.println(num);
        //num已经取得了链表的长度
        //map已经存储了链表的所有结点

        for (int i = 1; i <= num / 2; i++) {
            map.get(i).next = map.get(num + 1 -i);

            //处理边界
            if(i == num/2)
            {
                //如果链表长度为奇数
                if(num %2 == 1)
                {
                    map.get(num + 1 - i).next = map.get(i+1);
                    map.get(i+1).next =null;
                }
                //如果链表长度为偶数
                else
                {
                    map.get(num +1 -i).next =null;
                }
            }
            //正常处理每个结点
            else
            {
                map.get(num + 1 - i).next = map.get(i+1);
            }
        }
    }
}
