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
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp != null){
                l.add(temp.val);
                temp=temp.next;
            }
        }

        Collections.sort(l);
        ListNode dummy = new ListNode(0);
        ListNode temp=dummy;
        for(int i = 0;i<l.size();i++){
            temp.next= new ListNode(l.get(i));
            temp=temp.next;
        }
        return dummy.next;
        
    }
}