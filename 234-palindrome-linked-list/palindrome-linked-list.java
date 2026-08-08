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
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        ListNode front = null;
        while(temp != null){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
      
      ListNode middle = findmiddle(head);
      ListNode newhead = reverse(middle.next);

      ListNode first=head;
      ListNode second=newhead;
      while(second != null){
        if(first.val != second.val){
            return false;
        }
        first=first.next;
        second=second.next;
      }
    return true;
    }
}