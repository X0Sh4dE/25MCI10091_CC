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
    TreeNode prev = null;
    int mindif = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mindif;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null) {
            mindif = Math.min(mindif, Math.abs(root.val - prev.val));
        }
        prev = root;
        inorder(root.right);
    }
}
