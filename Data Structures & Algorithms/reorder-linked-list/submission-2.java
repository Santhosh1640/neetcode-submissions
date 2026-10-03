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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null) {
            st.push(curr);
            curr = curr.next;
        }

        int c = st.size()/2;
        curr = head;
        ListNode nxt = head;

        while(c>0) {
            ListNode node = st.pop();
            nxt = curr.next;
            curr.next = node;
            node.next = nxt;
            curr = nxt;
            c--;
        }
        curr.next = null;
          
    }
}
