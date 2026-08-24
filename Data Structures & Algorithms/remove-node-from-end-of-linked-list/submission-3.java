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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int l = 0;
        while(curr!=null) {
            l++;
            curr = curr.next;
        }

        if(n==l){
            return head.next;
        }

        int steps = l-n-1;
        curr = head;

        while(steps>0) {
            curr = curr.next;
            steps--;
        }

        curr.next = curr.next.next;

        return head;


    }
}
