package middle;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: Node
 * @Author: EdwardX
 * @Description: 完全二叉树的结点
 * @Date: 2020/10/15 21:42
 * @Version: 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
