package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: middle
 * @ClassName: solution_103
 * @Author: EdwardX
 * @Description: 103. 二叉树的锯齿形层序遍历
 * @Date: 2020/12/22 9:38
 * @Version: 1.0
 */
public class solution_103 {

    public static void LawyerTraversal(TreeNode root){
        if(root==null) return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        while(!list.isEmpty()){

            //poll()方法，就是直接删除第一个元素
            //如果集合为空，则会返回一个空元素
            currentNode=list.poll();

            //输出操作
            System.out.println(currentNode.val);

            if(currentNode.left!=null){
                list.add(currentNode.left);
            }

            if(currentNode.right!=null){
                list.add(currentNode.right);
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        //如果层数为奇数层
        if ((level & 1) == 1){
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }


    //BFS遍历
    //非递归遍历
    public List<List<Integer>> zigzagLevelOrder11(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 统计这一层的节点数
        while (!queue.isEmpty()) {
            // 该层的节点数量
            int levelCount = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();

            while (levelCount > 0) {
                TreeNode node = queue.poll();
                // 根据层次来判断顺序
                if (result.size() % 2 == 0) {
                    sub.add(node.val);
                } else {
                    //在0号位插入一个数字
                    sub.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelCount--;
            }
            result.add(sub);
        }

        return result;
    }


}

