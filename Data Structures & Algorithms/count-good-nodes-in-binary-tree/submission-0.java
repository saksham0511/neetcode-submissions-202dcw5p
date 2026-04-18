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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        count(root, -101);
        return ans;
    }

    public void count(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            ans++;
        }
        count(root.left, Math.max(root.val, max));
        count(root.right, Math.max(root.val, max));
    }
}
