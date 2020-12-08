

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: remove_duplicates_from_sorted_list_solution
 * @Author: EdwardX
 * @Description: 83
 * @Date: 2020/10/6 8:19
 * @Version: 1.0
 */
public class remove_duplicates_from_sorted_list_solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode newNode = head;
        while (newNode.next != null) {
            if (newNode.val == newNode.next.val) {
                newNode.next = newNode.next.next;
            } else
                newNode = newNode.next;

        }

        return head;
    }
}
