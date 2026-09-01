/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
    public PriorityQueue<Integer> helper(TreeNode root) {
        if(root==null) return pq;

        helper(root.left);
        pq.offer(root.val);
        helper(root.right);

        return pq;
    }
    public int kthSmallest(TreeNode root, int k) {
        pq = helper(root);
        while(k>1) {
            pq.poll();
            k--;
        }
        return pq.peek();
        
    }
}
