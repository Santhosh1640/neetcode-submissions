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
        ListNode curr = head;
        Stack<ListNode> st = new Stack<>();
        while(curr!=null) {
            st.push(curr);
            curr = curr.next;
        }
        curr = head;
        int c = st.size()/2;

        while(c>0) {
            ListNode nxt = curr.next;
            ListNode node = st.pop();
            curr.next = node;
            node.next = nxt;
            curr = nxt;
            nxt = curr.next;
            c--;
        }
        curr.next = null;
        

    }
}
