/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty. Notes: You must use only standard operations of a queue -- which
 * means only push to back, peek/pop from front, size, and is empty operations
 * are valid. Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue), as
 * long as you use only standard operations of a queue. You may assume that all
 * operations are valid (for example, no pop or top operations will be called on
 * an empty stack).
 *
 * @author kyle
 */
class MyStack {
    
    
 private void SelfTest() {
//        mQueue.add(null);
//     this.push(1);
//     push(2);
//     pop();
     
     push(1);
     push(2);
     push(3);
     push(4);
     Util.sop(top());
     pop();
     Util.sop(top());
     pop();
     Util.sop(top());
     Util.sop(empty());
     pop();
     Util.sop(top());
     Util.sop(empty());
     pop();
     Util.sop(empty());
            
    }
 
    private Queue<Integer> mQueue = null;

    MyStack() {        
        mQueue = new ArrayDeque<>();
        SelfTest();
    }

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> tmp = new ArrayDeque<>();
        tmp.add((Integer)x);
        int len = mQueue.size();
        for (int i = 0; i < len; i++) {
            tmp.add(mQueue.element());
            mQueue.poll();
        }
        mQueue = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(mQueue.size() != 0)
            mQueue.remove();
    }

    // Get the top element.
    public int top() {
        return mQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mQueue == null ? true : mQueue.isEmpty();
    }
}
