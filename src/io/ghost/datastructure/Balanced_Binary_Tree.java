package io.ghost.datastructure;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        boolean l = isBalanced(root.left);
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        if (Math.abs(heightRight - heightLeft) > 1) return false;
        boolean r = isBalanced(root.right);
        return l && r;
    }

    public static int height(TreeNode root) {
        int left =0, right=0;
        if (root == null) return 0;
        left += height(root.left);
        right += height(root.right);
        return Math.max(left, right) + 1;
    }
}
