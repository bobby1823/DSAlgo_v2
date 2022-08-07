package io.ghost.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Find a pair in Binary Tree whose sum is the number given.
 *
 * Here we will use a Map and store the node if the complementary of that number in not present in Map.
 * The moment we got the complementary then return true.
 */
public class Pair_BinaryTree_TwoSum {

    // Recursive way
    public static boolean checkIfPairPresent(TreeNode root, int num) {

        Map<Integer, TreeNode> map = new HashMap<>();
        return util(root, num, map);
    }

    public static boolean util(TreeNode root, int num, Map<Integer, TreeNode> map) {
        if (root == null) return false;

        if (map.containsKey((num-root.data))) {
            return true;
        } else {
            map.put(root.data, root);
            // check this OR condition. The moment we got the number complementary number then return.
            return util(root.left, num, map) || util(root.right, num, map);
        }
    }
}
