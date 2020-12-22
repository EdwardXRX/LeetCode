package study;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: study
 * @ClassName: tree_test
 * @Author: EdwardX
 * @Description:
 * @Date: 2020/12/22 10:08
 * @Version: 1.0
 */

import java.util.LinkedList;
import java.util.Stack;

class TreeNode<E>{
    E data;
    TreeNode<E> left, right;
    public TreeNode(E data) {
        this.data=data;
        this.left =null;
        this.right =null;
    }
}

public class tree_test<E> {

    private TreeNode<E> root;

    public tree_test() {
        //root=new BiTNode(null, null, null);
        root=null;
    }

    /*
     * 前序遍历
     */
    public void preOrder() {
        preOrderTraverse(root);
        System.out.println();
    }
    private void preOrderTraverse(TreeNode<E> node) {
        if(node==null)
            return;
        System.out.print(node.data);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /*
     * 中序遍历
     */
    public void inOrder() {
        inOrderTraverse(root);
        System.out.println();
    }
    private void inOrderTraverse(TreeNode<E> node) {
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data);
        inOrderTraverse(node.right);
    }

    /*
     * 后序遍历
     */
    public void postOrder() {
        postOrderTraverse(root);
        System.out.println();
    }
    private void postOrderTraverse(TreeNode<E> node) {
        if(node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data);
    }


    //===============循环遍历===============
    /**
     * 前序遍历（非递归）
     */
    public void preOrder2() {
        preOrder2(root);
        System.out.println();
    }
    private void preOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(node!=null||!stack.isEmpty()) {
            while(node!=null) {
                System.out.print(node.data);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop().right;
        }
    }


    /**
     * 中序遍历
     */
    public void inOrder2() {
        inOrder2(root);
        System.out.println();
    }
    private void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(node!=null||!stack.isEmpty()) {
            while(node!=null) {
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            System.out.print(node.data);
            node=node.right;
        }
    }


    /**
     * 后序遍历
     */
    public void postOrder2() {
        postOrder2(root);
        System.out.println();
    }
    private void postOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> tag = new Stack<Integer>();
//      while(node!=null||!stack.isEmpty()) {
//          while(node!=null){
//              stack.push(node);
//              tag.push(0);
//              node=node.lchild;
//          }
        //这里的tag用于标记当前结点是否完成左右子结点遍历（所以用0，1表示）
//          while(!tag.isEmpty()&&tag.peek()==1) {  //栈顶节点的左右子结点已完成遍历
//              System.out.print(stack.pop().data);
//              tag.pop();
//          }
//          if(!tag.isEmpty()) {   //上面和这里的 !flag.isEmpty() 不可省略，不然会出错。
//              tag.pop();
//              tag.push(1);
//              node=stack.peek().rchild;
//          }
//      }
        /*后序遍历时，分别从左子树和右子树共两次返回根结点（用tag表示次数），
         * 只有从右子树返回时才访问根结点，所以增加一个栈标记到达结点的次序。
         */
        while(node!=null||!stack.isEmpty()) {
            if(node!=null){
                stack.push(node);
                tag.push(1);  //第一次访问
                node=node.left;
            }else {
                if(tag.peek()==2) {
                    System.out.print(stack.pop().data);

                    tag.pop();
                }else {
                    tag.pop();
                    tag.push(2); //第二次访问
                    node=stack.peek().right;
                }
            }
        }
    }


    //=========层序遍历============
    public void levelOrder() {
        TreeNode<E> node =root;
        LinkedList<TreeNode<E>> list = new LinkedList<>();
        list.add(node);
        while(!list.isEmpty()) {
            node=list.poll();
            System.out.print(node.data);
            if(node.left !=null)
                list.offer(node.left);
            if(node.right !=null)
                list.offer(node.right);
        }
    }


    public static void main(String[] args) {
        tree_test<String> aBiTree = new tree_test<String>();
        aBiTree.root=new TreeNode<String>("A");
        aBiTree.root.left =new TreeNode<String>("B");
        aBiTree.root.right =new TreeNode<String>("C");
        aBiTree.root.left.right =new TreeNode<String>("D");

//      BiTree<String> aBiTree = new BiTree<String>();
//      aBiTree.root=new BiTNode("A");
//      aBiTree.root.lchild=new BiTNode("B");
//      aBiTree.root.lchild.lchild=new BiTNode("C");
//      aBiTree.root.lchild.lchild.lchild=new BiTNode("D");
//      aBiTree.root.lchild.rchild=new BiTNode("E");
//      aBiTree.root.lchild.rchild.lchild=new BiTNode("F");
//      aBiTree.root.lchild.rchild.lchild.rchild=new BiTNode("G");
//      aBiTree.root.lchild.rchild.lchild.rchild.rchild=new BiTNode("H");

        System.out.println("————前序————");
        aBiTree.preOrder();
        aBiTree.preOrder2();
        System.out.println("————中序————");
        aBiTree.inOrder();
        aBiTree.inOrder2();
        System.out.println("————后序————");
        aBiTree.postOrder();
        aBiTree.postOrder2();
        System.out.println("————层序遍历————");
        aBiTree.levelOrder();
    }
}