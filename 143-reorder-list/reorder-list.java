/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr != null){
            ListNode front = curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }
        ListNode middle = findmiddle(head);
        ListNode second = middle.next;
        middle.next=null;
        second = reverse(second);
        ListNode first = head;

        while(second != null){

            ListNode firstnext = first.next;
            ListNode secnext = second.next;

            first.next = second;
            second.next=firstnext;

            first=firstnext;
            second = secnext;
        }
    }
}