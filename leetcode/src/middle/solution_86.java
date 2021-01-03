package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_86
 * @Author: EdwardX
 * @Description: 86. 分隔链表
 * @Date: 2021/1/3 9:17
 * @Version: 1.0
 */

/*
给你一个链表和一个特定值 x ，请你对链表进行分隔，

使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5

*/
public class solution_86 {

    //超出时间限制
    public ListNode partition(ListNode head, int x) {

        //stack1存储大于等于
        Stack<Integer> stack1 = new Stack<>();
        //stack2存储小于
        Stack<Integer> stack2 = new Stack<>();

        while (head != null) {
            if (head.val >= x)
                stack1.add(head.val);
            else stack2.add(head.val);
        }

        //头插法
        ListNode xxx1 = new ListNode(-1);
        while (stack1.isEmpty()) {
            ListNode node = new ListNode(stack1.pop());
            node.next = xxx1.next;
            xxx1.next = node;
        }

        //头插法
        ListNode xxx2 = new ListNode(-1);
        while (stack2.isEmpty()) {
            ListNode node = new ListNode(stack2.pop());
            node.next = xxx2.next;
            xxx2.next = node;
        }

        ListNode index = xxx2;
        while (index.next != null) {
            index = index.next;
        }
        //连接两个链表
        index = xxx1.next;

        return xxx2.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }

}
