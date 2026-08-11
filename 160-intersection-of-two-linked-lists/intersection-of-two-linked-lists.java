/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {


    static ListNode collisionPoint(ListNode h1,ListNode h2,int diff){

        ListNode t1=h1;
        ListNode t2=h2;
        for(int i = 0;i<diff;i++){
            t2=t2.next;
        }
        while(t1 != t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode t1=headA;
        ListNode t2=headB;
        int n1=0,n2=0;
        while(t1 != null){
            n1++;
            t1=t1.next;
        }
        while(t2!=null){
            n2++;
            t2=t2.next;
        }
        if(n1 < n2){
            return collisionPoint(headA,headB,n2-n1);
        }else{
            return collisionPoint(headB,headA,n1-n2);
        }
        
    }
}