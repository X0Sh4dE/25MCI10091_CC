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
    static class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public Pair solve(TreeNode root) {
        if (root == null) return new Pair(-1, root);
        if (root.left == null && root.right == null) return new Pair(0, root);

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.node);
        } else if (left.depth < right.depth) {
            return new Pair(right.depth + 1, right.node);
        } else {
            return new Pair(left.depth + 1, root);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = solve(root);
        return p.node;
    }
}
