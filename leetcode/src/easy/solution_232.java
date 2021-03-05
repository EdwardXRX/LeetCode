package easy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: easy
 * @ClassName: solution_232
 * @Author: EdwardX
 * @Description: 232. 用栈实现队列
 * @Date: 2021/3/5 8:56
 * @Version: 1.0
 */
public class solution_232 {
    /**
     * Initialize your data structure here.
     */

    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    public solution_232() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty() == false) {
            return stack2.pop();
        } else if (stack1.isEmpty() == false) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty() == false) {
            return stack2.peek();
        } else if (stack1.isEmpty() == false) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}
