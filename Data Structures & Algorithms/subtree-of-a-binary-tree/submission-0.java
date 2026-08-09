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
    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) {
            return true;
        }
        if(root==null || subRoot==null) {
            return false;
        }
        return root.val==subRoot.val &&
                sameTree(root.left, subRoot.left) &&
                sameTree(root.right, subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) {
            return true;
        }
        if(root==null) {
            return false;
        }

        if(sameTree(root, subRoot)) return true;

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right;
        
    }
}
