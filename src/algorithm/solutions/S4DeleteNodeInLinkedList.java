/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node. Supposed the linked list is 1 -> 2 -> 3 -> 4
 * and you are given the third node with value 3, the linked list should become
 * 1 -> 2 -> 4 after calling your function.
 *
 * @author kyle
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class S4DeleteNodeInLinkedList {

    private static ListNode l1;

    // 4test
    S4DeleteNodeInLinkedList() {
        l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        deleteNode(l3);
//        if(l1 != null)Util.sop(l1.val);
        while (l1 != null) {
            Util.sop(l1.val);
            l1 = l1.next;
        }
    }

    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
