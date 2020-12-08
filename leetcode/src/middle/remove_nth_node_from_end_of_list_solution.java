package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: remove_nth_node_from_end_of_list_solution
 * @Author: EdwardX
 * @Description: 19. 删除链表的倒数第N个节点
 * @Date: 2020/10/18 21:11
 * @Version: 1.0
 */
public class remove_nth_node_from_end_of_list_solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;

        //让t指向当前链表的最后结点
        int length = 1;
        ListNode t = head;
        while (t.next != null) {
            length++;
            t = t.next;
        }

        //输出长度，检测
        System.out.println(length);

        t = head;
        for (int i = 0; i < (length - n -1); i++) {
            t = t.next;
        }
        //t当前指向待删除的前一个结点
        if(n ==1)
        {
            t.next = null;
        }
        else if(n == length)
        {
            return head.next;
        }
        else
        {
            t.next = t.next.next;
        }

        System.out.println(head.val);
        return head;
    }
}
