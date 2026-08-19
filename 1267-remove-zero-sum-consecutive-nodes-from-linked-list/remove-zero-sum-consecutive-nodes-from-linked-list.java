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
    public ListNode removeZeroSumSublists(ListNode head) {

        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode dummyH = new ListNode(0);
        dummyH.next = head;
        ListNode temp=dummyH;
        int sum=0;
        while(temp != null){
            sum += temp.val;
            map.put(sum,temp);
            temp=temp.next;
        }

        temp=dummyH;
        sum=0;
        while(temp != null){
            sum += temp.val;
            temp.next = map.get(sum).next;
            temp=temp.next;
        }
        return dummyH.next;
    }
}