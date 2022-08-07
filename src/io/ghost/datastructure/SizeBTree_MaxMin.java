package io.ghost.datastructure;

/**
 * Size of Binary tree means the total number of nodes present in B-Tree
 */
public class SizeBTree_MaxMin {

    public static int sizeOfBinaryTree(TreeNode root) {
//        int countLeft = 0;
//        int countRight = 0;
        if (root == null) return 0;
//        countLeft += sizeOfBinaryTree(root.left) + 1;
//        countRight += sizeOfBinaryTree(root.right) + 1;
        // recursion will handle the left and right part of Tree
        return sizeOfBinaryTree(root.left)+1+sizeOfBinaryTree(root.right);
    }

    /**
     * Space Complexity is O(height of tree)
     * Time Complexity is O(n) as every node is visited once
     * @param root
     * @return
     */
    public static int maxInBinaryTree(TreeNode root) {
        // Min_VALUE has been taken to handle the negative integers in Tree. Basically it negative infinity when we
        // get null
        if (root == null) return Integer.MIN_VALUE;
        int data = root.data;
        int left = maxInBinaryTree(root.left);
        int right = maxInBinaryTree(root.right);

        if (data > left) {
            if (data < right) {
                return right;
            } else {
                return data;
            }
        } else {
            if (left < right) {
                return right;
            } else {
                return left;
            }
        }
    }

    public static int minInBinaryTree(TreeNode root) {
        // Max_VALUE has been taken to handle the negative integers in Tree. Basically it infinity when we
        // get null
        if (root == null) return Integer.MAX_VALUE;

        return Math.min(root.data, Math.min(minInBinaryTree(root.left), minInBinaryTree(root.right)));
    }
}
