package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_2
 * @Author: EdwardX
 * @Description: 2. 两数相加
 * @Date: 2021/1/9 19:37
 * @Version: 1.0
 */
/*
* 给你两个 非空 的链表，表示两个非负的整数。
*
* 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

*/
public class solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }


        ListNode runNode = null;
        ListNode head = runNode;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();

            //两个结点都有值
            if (l1 != null && l2 != null) {
                if ((l1.val + l2.val) >= 10) {
                    if (flag == true) {
                        node.val = l1.val + l2.val + 1 - 10;
                    } else {
                        node.val = l1.val + l2.val - 10;
                    }
                    flag = true;
                } else {
                    if (flag == true) {
                        {
                            if (l1.val + l2.val + 1 == 10) {
                                node.val = 0;
                                flag = true;
                            } else {
                                node.val = l1.val + l2.val;
                                flag = false;
                            }
                        }
                    } else {
                        node.val = l1.val + l2.val;
                        flag = false;
                    }
                }

                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                if (flag == true) {
                    if (l2.val == 9) {
                        flag = true;
                        node.val = 0;
                    } else {
                        flag = false;
                        node.val = l2.val + 1;
                    }
                } else {
                    node.val = l2.val;
                    flag = false;
                }
            } else if (l1 != null && l2 == null) {
                if (flag == true) {
                    if (l1.val == 9) {
                        flag = true;
                        node.val = 0;
                    } else {
                        flag = false;
                        node.val = l1.val + 1;
                    }
                } else {
                    node.val = l1.val;
                    flag = false;
                }
            }

            runNode.next = node;
            runNode = runNode.next;
        }

        if (flag == true) {
            ListNode node = new ListNode(1);
            runNode.next = node;
            node.next = null;
        }
        return head.next;

    }

}
