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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode helper(int[] preorder, int x, int y, int[] inorder, int a, int b) {
        if (a > b) {
            return null;
        }
        if (a == b) {
            return new TreeNode(preorder[x]);
        }
        int root = preorder[x];
        int index = -1;
        for (int i = a; i <= b; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        int i = index;
        TreeNode node = new TreeNode(root);
        node.left = helper(preorder, x+1, x+i-a, inorder, a,i-1);
        node.right = helper(preorder, x+i-a+1, y, inorder, i+1, b);
        return node;
    }
}
