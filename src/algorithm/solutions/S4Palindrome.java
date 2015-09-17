/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kyle
 */
public class S4Palindrome {
    S4Palindrome(){
        super();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(1);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
        List<ListNode> list = new ArrayList<ListNode>();
        System.out.println(isPalindrome(l1));
    }
    

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if(head.next.next == null) return head.equals(head.next);
        ListNode slow = head;
        ListNode fast = head.next;
        //find middle of the linked list 
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the last half of the list
        ListNode current = slow.next;
        ListNode p;
        while (current.next != null) {
            p = current.next;
            current.next = p.next;
            p.next = slow.next;
            slow.next = p;
        }

        //judge
        while (head.next != null && slow.next != null) {
            if (head.val != slow.val) {
                return false;
            }
            head.next = head.next.next;
            slow.next = slow.next.next;
        }
        return true;

    }

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
