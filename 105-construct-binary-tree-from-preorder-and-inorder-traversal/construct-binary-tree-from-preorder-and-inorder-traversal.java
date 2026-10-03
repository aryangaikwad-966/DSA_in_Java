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
import java.util.HashMap;
import java.util.Map;

class Solution {

    static int preorderIndex = 0;
    static Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderMap.clear();
        preorderIndex = 0;

        for (int i= 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

     return build(preorder, 0, inorder.length - 1);
    }

    static TreeNode build(int[] preorder, int left, int right) {

    if (left >right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.left = build(
            preorder,
            left,
            rootIndex - 1
        );

        root.right = build(
            preorder,
            rootIndex + 1,
            right
        );

        return root;
    }
}