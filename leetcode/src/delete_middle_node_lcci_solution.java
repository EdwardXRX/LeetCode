/**
 * @ProjectName: IDEA_PROJECT
 * @Package: PACKAGE_NAME
 * @ClassName: delete_middle_node_lcci_solution
 * @Author: EdwardX
 * @Description: 面试题 02.03. 删除中间节点
 * @Date: 2020/10/17 8:25
 * @Version: 1.0
 */
public class delete_middle_node_lcci_solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
