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
    int balanced = 1;

    public boolean isBalanced(TreeNode root) {
        balance(root);
        if (balanced == 1) {
            return true;
        }
        return false;
    }

    public int balance(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int hl = 1 + balance(node.left);
        int hr = 1 + balance(node.right);
        if (Math.abs(hl - hr) > 1) {
            balanced = 0;
        }
        return Math.max(hl, hr);
    }
}
