/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.get(temp)>=2){
                return true;
            }
            temp=temp.next;
        }
        return false;        
    }
}