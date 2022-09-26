package io.ghost.datastructure;

public class InvertBinaryTree {

    /**
     *
     * To Invert the tree, we just need to do a Pre Order traversal. Some operation (i.e swap left to right & right to left
     * we have to do before going on next node)
     *
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = tempRight;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
