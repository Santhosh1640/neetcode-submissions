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
         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
         ListNode result = new ListNode(0);
         ListNode temp = result;

         for(ListNode list:lists) {
            if(list!=null) {
                pq.offer(list);

            }
         }

         while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next!=null) {
                pq.offer(node.next);
            }
         }
         return result.next;

   
    }
}
