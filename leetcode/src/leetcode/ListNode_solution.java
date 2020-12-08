package leetcode;

import javax.management.StandardEmitterMBean;

public class ListNode_solution {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        ListNode temp = null;

        if (l1.val <= l2.val) {
            temp = l1;
            l1 = l1.next;
        } else {
            temp = l2;
            l2 = l2.next;
        }


        ListNode back = temp;


        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;

            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        if (l1 == null)
            temp.next = l2;
        if (l2 == null)
            temp.next = l1;

        return back;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        int[] i1 = {1, 3, 5, 7, 8};
        int[] i2 = {2, 4, 6, 8, 10};

        for (int i = 0; i < i1.length; i++) {
            l1.val=i1[i];
            l1 = l1.next;
        }

        for (int i = 0; i < i2.length; i++) {
            l2.val = i2[i];
            l2 = l2.next;
        }

        while (l2!=null) {
            System.out.println(l2.val);
            l2=l2.next;
        }

    }
}
