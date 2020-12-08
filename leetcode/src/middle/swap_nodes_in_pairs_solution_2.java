package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: swap_nodes_in_pairs_solution_2
 * @Author: EdwardX
 * @Description: 24. 两两交换链表中的节点
 * @Date: 2020/10/14 7:55
 * @Version: 1.0
 */
public class swap_nodes_in_pairs_solution_2 {
    ListNode list1;
    ListNode list2;

    public ListNode swapPairs(ListNode head) {
        //若空指针，则返回null
        if (head == null)
            return null;

        //若此链表仅含一个节点，则直接返回
        if (head.next == null)
            return head;

        list1 = head;
        list2 = head.next;

        split(head,head.next,head);



        return together(list1,list2);
    }

    //将链表按照位置的奇偶顺序拆分成两个链表
    public void split(ListNode list1, ListNode list2, ListNode head) {
        int i = 1;
        while (head != null) {
            //奇数操作
            if (i % 2 == 1) {
                list1 = head;
                head = head.next;
                if (head != null) {
                    list1 = head.next;
                } else {
                    list1.next = null;
                }
                list1 = head.next;
                i++;
            }
            //偶数操作
            else {
                list2 = head;
                head = head.next;
                //判断操作
                if (head != null) {
                    list2 = head.next;
                } else {
                    list2.next = null;
                }
                i++;
            }
        }
    }

    public ListNode together (ListNode list1 ,ListNode list2)
    {

        ListNode  prePoint = list2;
        ListNode head = list2;
        int i =2;
        while(list1 !=null && list2 !=null){
            if(i % 2 ==1){
                prePoint.next = list1;
                list1 = list1.next;
                i++;
            }else{
                prePoint.next = list2;
                list2 = list2.next;
                i++;
            }
            prePoint = prePoint.next;
        }
        return head;

    }
}
