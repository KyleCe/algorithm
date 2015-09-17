/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;
import java.util.Stack;

/**
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty. Notes: You must use only standard operations of a
 * stack -- which means only push to top, peek/pop from top, size, and is empty
 * operations are valid. Depending on your language, stack may not be supported
 * natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. You may
 * assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 *
 * @author kyle
 */
public class S4ImplementQueueUsingStack {

    S4ImplementQueueUsingStack() {
        SelfTest();
    }

    private void SelfTest() {
        push(1);
        push(2);
        push(3);
        push(4);
        Util.sop(peek());
        pop();
        Util.sop(peek());
        pop();
        Util.sop(peek());
        Util.sop(empty());
        pop();
        Util.sop(peek());
        Util.sop(empty());
        pop();
        Util.sop(peek());
        Util.sop(empty());

    }

    private Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            tmp.push(stack.peek());
            stack.pop();
        }
        stack.add(x);
        for (int i = 0; i < len; i++) {
            stack.add(tmp.peek());
            tmp.pop();
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack != null) stack.pop();
    }

    // Get the front element.
    public int peek() {
        return (Integer) stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack == null ? true : stack.isEmpty();
    }

}
