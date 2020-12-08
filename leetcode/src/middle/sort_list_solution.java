package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: sort_list_solution
 * @Author: EdwardX
 * @Description: 148. 排序链表
 * @Date: 2020/11/21 8:06
 * @Version: 1.0
 */
public class sort_list_solution {
    public ListNode sortList(ListNode head) {

        //专门opt进行操作
        ListNode opt = head;
        int index = getLength(head);

        while (index > 1) {
            //大循环不断更新opt
            //使opt重置指向head
            opt = head;

            for (int j = 0; j < index - 1; j++) {

                //如果乱序，就交换val
                if (opt.val > opt.next.val) {
                    int temp = opt.val;
                    opt.val = opt.next.val;
                    opt.next.val = temp;
                }

                //向后移动
                opt = opt.next;
            }
            index--;


        }

        return head;

    }

    //求得链表长度
    public int getLength(ListNode head) {
        int index = 0;
        while (head != null) {
            index++;
        }
        return index;
    }
}
