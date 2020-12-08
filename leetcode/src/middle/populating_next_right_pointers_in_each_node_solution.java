package middle;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: populating_next_right_pointers_in_each_node_solution
 * @Author: EdwardX
 * @Description: 116. 填充每个节点的下一个右侧节点指针
 * @Date: 2020/10/15 21:41
 * @Version: 1.0
 */
public class populating_next_right_pointers_in_each_node_solution {

    List<Node> list = new ArrayList<Node>();
    public Node connect(Node root) {
        if(root == null)
            return null;

        //层序遍历二叉树
        levelOrder(root);

        //high获得了树的高度。通过树的高度，可以将结点们分层
        int high = (int) (Math.log(list.size() +1)/ Math.log(2));
        System.out.println(high);
        System.out.println(list);

        for (int i = 0; i < high; i++) {
            for (int j = (int)(Math.pow(2,i))-1; j <=2 * ((int)(Math.pow(2,i))-1) ; j++) {
                    if(j ==2* ((int)(Math.pow(2,i))-1))
                    {
                        list.get(j).next = null;
                    }else
                    {
                        list.get(j).next = list.get(j+1);
                    }
            }
        }
        return root;
    }
    public void dfs(Node root)
    {
        if(root != null)
        {
            list.add(root);
            dfs(root.left);
            dfs(root.right);
        }
    }

    public  void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        Node curr;
        queue.add(root);
        while (!queue.isEmpty()) {
            curr = queue.remove();
            list.add(curr);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

}
