package easy;

import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: palindrome_linked_list_solution
 * @Author: EdwardX
 * @Description: 234. 回文链表
 * @Date: 2020/10/23 8:55
 * @Version: 1.0
 */
public class palindrome_linked_list_solution {

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        Stack<ListNode> stack = new Stack<>();

        //使head指向链表的中间结点。
        int length = getLength(head);
        for (int i = 0; i < length / 2; i++) {
            stack.push(head);
            head = head.next;
        }
        //如果是奇数，则让head向后移一步
        if (length % 2 == 1) {
            head = head.next;
        }

        while (!stack.isEmpty()) {
            if (stack.peek().val != head.val) {
                return false;
            } else {
                stack.pop();
                head = head.next;
            }
        }
        return true;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
