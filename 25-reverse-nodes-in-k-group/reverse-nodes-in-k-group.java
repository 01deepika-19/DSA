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

    static ListNode findkth(ListNode temp,int k){
        k-=1;
        while(temp != null && k >0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    static void reverse(ListNode h){

        ListNode prev=null;
        ListNode temp = h;
        while(temp != null){
            ListNode front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev=null;
        while(temp != null){
            ListNode kth = findkth(temp,k);
            if(kth == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode nextNode = kth.next;
            kth.next = null;
            reverse(temp);
            if(temp == head){
                head=kth;
            }else{
                prev.next=kth;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
        
    }
}