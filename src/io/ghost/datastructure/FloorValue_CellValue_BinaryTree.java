package io.ghost.datastructure;

public class FloorValue_CellValue_BinaryTree {

    // Find the Floor value of given number
    // Floor Value: is the smallest value amongst the largest one
    // Recursion way
    static int floorValue = Integer.MAX_VALUE;
    static int ceilValue = Integer.MIN_VALUE;

    public static int floorValue_V1(TreeNode root, int num) {
        if (root == null) return floorValue;

        if (num < root.data) return floorValue_V1(root.left, num);

        floorValue = root.data;
        return floorValue_V1(root.right, num);
    }

    // Iterative Way
    // Iteration is more optimized over recursion stack. Since due to recursion stack we get one call piled up after another
    // So, space complexity of recursion stack is O(h), where height is h=height.

    // This can be solved in another way by storing all the nodes data in a array by InOrder traversal. And then using
    // Binary search on the array for the number.
    public static int floorValue_V2(TreeNode root, int num) {
        TreeNode node = root;

        while (node != null) {
            if (node.data > num) {
                node = node.left;
            } else {
                floorValue = node.data;
                node = node.right;
            }
        }
        return floorValue;
    }

    public static int ceilValue_V2(TreeNode root, int num) {
        TreeNode node = root;

        while (node != null) {
            if (node.data > num) {
                floorValue = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return floorValue;
    }
}
