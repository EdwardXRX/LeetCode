package middle;


import javax.management.relation.Role;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: swap_nodes_in_pairs_solution
 * @Author: EdwardX
 * @Description: 24. 两两交换链表中的节点
 * @Date: 2020/10/13 21:51
 * @Version: 1.0
 */
public class swap_nodes_in_pairs_solution {

    public ListNode swapPairs(ListNode head) {
        //若空指针，则返回null
        if (head == null)
            return null;

        //若此链表仅含一个节点，则直接返回
        if (head.next == null)
            return head;

        ListNode old_head = head.next;
        ListNode back = head;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode h1 = head;
        stack1.push(h1);
        head = head.next;
        h1.next = null;

        while (head.next != null) {
            stack1.push(head.next);
            head.next = head.next.next;
            head.next.next = null;
            head = head.next;
        }


        //双栈模拟队列
        while (stack1.isEmpty() ==false) {
            stack2.push(stack1.pop());
        }

        ListNode peek;
        while (stack2.isEmpty() ==false) {
            peek = stack2.pop();
            peek.next = old_head.next;
            old_head.next = peek;
            old_head = peek.next;
        }
        return back;
    }


}
