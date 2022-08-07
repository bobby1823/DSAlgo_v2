package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the lowest common ancestor of Binary Tree
 */
public class LowestCommonAncestorBinaryTree {

    /**
     * A simple solution would be to store the path from root to x and the path from the root to y in two auxiliary arrays.
     * Then traverse both arrays simultaneously till the values in the arrays match. The last matched value will be the LCA.
     * If the end of one array is reached, then the last seen value is LCA. The time complexity of this solution is O(n),
     * where n is the total number of nodes in the binary tree. But the auxiliary space used by it is O(n) required for storing two arrays.
     */
    public static void traverse(TreeNode root, int num, List<Integer> arr) {
        if (root == null || (root.data == num)) return;

        arr.add(root.data);
        traverse(root.left, num, arr);
        traverse(root.right, num, arr);
    }

    public static void lowestCommonAncestor_V1(TreeNode root, int num1, int num2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        traverse(root, num1, arr1);
        traverse(root, num2, arr2);
        System.out.println(arr1);
        System.out.println(arr2);
    }

    /**
     * Here we solve in one iteration and without using any extra space.
     * solution: If root == null then return null
     *           If root.data == num1 or num2 then return num1/num2
     *           If num1 or num2 present in different sub tree then return root.
     *
     */
    public static TreeNode lowestCommonAncestor_V2(TreeNode root, int num1, int num2) {
        if (root == null) return null;
        if (root.data == num1 || root.data == num2) return root;

        TreeNode left = lowestCommonAncestor_V2(root.left, num1, num2);
        TreeNode right = lowestCommonAncestor_V2(root.right, num1, num2);
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
