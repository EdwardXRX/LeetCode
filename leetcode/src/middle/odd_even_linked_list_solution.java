package middle;

import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: odd_even_linked_list_solution
 * @Author: EdwardX
 * @Description: 328. 奇偶链表
 * @Date: 2020/11/13 8:43
 * @Version: 1.0
 */

/*给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。
你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL

*/
public class odd_even_linked_list_solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        //奇数位结点指针，初始指向第二个结点
        ListNode ji_head = head.next;
        //留到后面备用
        ListNode ji = head.next;
        //偶数位结点指针，初始指向第一个结点
        ListNode ou_head = head;

        while (true) {
            //当前结点（偶数结点）的next = 下一节点（奇数结点）的next
            ou_head.next = ji_head.next;
            //ou_head 指向那个位置
            ou_head = ji_head.next;
            //如果检测到后面一个是null，则直接退出
            if (ou_head.next == null)
                break;

            //同理
            ji_head.next = ou_head.next;
            ji_head = ou_head.next;
            //同理
            if (ji_head.next == null)
                break;
        }
        //如果是偶数位结点的next为空，说明链表中结点数为奇数个
        if (ou_head.next == null) {
            ou_head.next = ji;
            ji_head.next = null;
        }

        if (ji_head.next == null) {
            ou_head.next = ji;
        }
        return head;

    }
}
