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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (helper(root, target) == true) {
            return null;
        }
        return root;
    }

    public boolean helper(TreeNode root, int target) {
        if (root == null) {
            return true;
        }
        if(helper(root.left, target)){
            root.left = null;
        }
        if (helper(root.right, target)) {
            root.right = null;
        }
        return (root.val == target && root.left == null && root.right == null);
    }
}