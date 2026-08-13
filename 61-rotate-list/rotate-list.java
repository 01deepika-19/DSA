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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k== 0){return head;}
        ListNode temp =head;
        int n=0;
        while(temp != null){
            n++;
            temp=temp.next;
        }
        k=k%n;
        if(k==0){return head;}
        temp=head;
        for(int i = 0;i<n-k-1;i++){
            temp=temp.next;
        }
        ListNode sech= temp.next;
        ListNode curr=sech;
        temp.next=null;
        while(curr.next != null){
            curr=curr.next;
        }
        curr.next = head;
        return sech;
    }
}