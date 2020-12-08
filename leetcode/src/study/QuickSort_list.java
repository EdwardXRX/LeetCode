package study;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: study
 * @ClassName: QuickSort_list
 * @Author: EdwardX
 * @Description: 单链表的快速排序
 * @Date: 2020/11/21 9:43
 * @Version: 1.0
 */
public class QuickSort_list {

    public ListNode sortList(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }
    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }
}
