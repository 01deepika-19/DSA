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
    static ListNode merge2lists(ListNode h1,ListNode h2){
        ListNode t1=h1;
        ListNode t2=h2;
        ListNode dummy = new ListNode(0);
        ListNode temp=dummy;
        while(t1!=null && t2 != null){
            if(t1.val < t2.val){
                temp.next=t1;
                t1=t1.next;
                temp=temp.next;
            }else{
                temp.next=t2;
                t2=t2.next;
                temp=temp.next;
            }
        }
        if(t1!=null){
            temp.next=t1;
        }else{
            temp.next=t2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists){
     
    if(lists.length==0){return null;}
    ListNode head = lists[0];
    for(int i = 1;i<lists.length;i++){
        head = merge2lists(head,lists[i]);
    }
        return head;
    }
}