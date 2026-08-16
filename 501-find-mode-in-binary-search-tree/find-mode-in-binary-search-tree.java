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
    List<Integer> ans = new ArrayList<>();
    Integer prev = null;
    int count = 0, max = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        count = (prev != null && prev == root.val) ? count + 1 : 1;

        if (count > max) {
            max = count;
            ans.clear();
            ans.add(root.val);
        } else if (count == max) {
            ans.add(root.val);
        }

        prev = root.val;
        inorder(root.right);
    }
}