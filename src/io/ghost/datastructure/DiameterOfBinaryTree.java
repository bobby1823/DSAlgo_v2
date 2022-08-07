package io.ghost.datastructure;

/**
 * Find the diameter of Binary Tree.
 * It is the no. of nodes in the largest path between two leaf nodes.
 *
 * Solution:
 *          We can solve this by recursion. Find the diameter of left tree (using recursion leap of faith), right of Binary Tree.
 *          If root node is the in the path of diameter then we need to find the height of left sub tree and add +1
 */
public class DiameterOfBinaryTree {

    // Here the time complexity O(n*2). Because in diameterOfBt we are using one heightOfBR and another diameter.
    public static int diameterOfBT(TreeNode root) {
        if (root == null) return 0;

        int leftTreeDiameter = diameterOfBT(root.left);
        // This is done so that we calculate the height of both sub tree
        int totalHeight = heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right) + 1;
        int rightTreeDiameter = diameterOfBT(root.right);
        return Math.max(totalHeight, Math.max(leftTreeDiameter, rightTreeDiameter));
    }

    public static int heightOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
    }

    // Version-2: Here with extra space we are reducing time complexity to O(n)
    static int ans = 0;
    public static int heightOfBinaryTree_V2(TreeNode root) {
        if (root == null) return 0;
        int lHeight = heightOfBinaryTree_V2(root.left);
        int rHeight = heightOfBinaryTree_V2(root.right);
        ans = Math.max(ans, 1 + lHeight + rHeight );
        return 1 + Math.max(heightOfBinaryTree_V2(root.left), heightOfBinaryTree_V2(root.right));
    }
}
