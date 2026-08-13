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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode curr = head;
        ListNode leftpre=dummy;;
        for(int i = 0;i<left-1;i++){
            curr=curr.next;
            leftpre=leftpre.next;
        }
        ListNode sublisthead=curr;
        ListNode prev=null;
        ListNode front=null;
        for(int i = 0;i<right-left+1;i++){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        leftpre.next = prev;
        sublisthead.next = curr;
        return dummy.next;  
    }
}