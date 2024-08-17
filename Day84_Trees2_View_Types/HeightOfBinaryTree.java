package Day84_Trees2_View_Types;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return height(root);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int hl = 1 + height(node.left);
        int hr = 1 + height(node.right);
        return Math.max(hl, hr);
    }
}