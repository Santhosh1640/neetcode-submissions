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
    public TreeNode helper(int[] pre, int[] in, int ps, int pe, int is, int ie,
    Map<Integer,Integer> map) {
        if(ps>pe || is>ie) {
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot-is;
        root.left = helper(pre, in, ps+1, ps+numsLeft, is, inRoot-1, map);
        root.right = helper(pre, in, ps+numsLeft+1, pe, inRoot+1, ie, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
    }
}
