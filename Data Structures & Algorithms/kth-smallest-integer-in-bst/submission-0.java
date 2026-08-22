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
    int curr;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);
        return ans;
    }

    public void travel(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        travel(root.left, k);
        if (curr == k-1) {
            ans = root.val;
        }
        curr += 1;
        travel(root.right, k);
    }
}
