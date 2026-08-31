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
    int cnt = 0;
    public void helper(TreeNode root, int maxx) {
        if(root==null) {
            return;
        }
        if(root.val >= maxx) {
            cnt++;
            maxx = root.val;
        }
        helper(root.left, maxx);
        helper(root.right, maxx);
    }
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return cnt;
    }
}
