package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Here we are going to using hashMap instead of Queue.
 * Approach: in HashMap each level will be correspond to each key in hashMap and in value will be an ArrayList.
 *           So, we will traverse each node in BT and store in correcsponding key - value
 */
public class LevelOrderTraversalBinaryTree_HashMap {

    // L-N-R
    // Traverse the tree in a inorder fashion and store nodes in a map
    // corresponding to their level
    public static void preOrderTraversal(TreeNode root, int level, HashMap<Integer, List<Integer>> hashMap) {
        if (root == null) return;

        if (hashMap.containsKey(level)) {
            List<Integer> list = hashMap.get(level);
            list.add(root.data);
            hashMap.put(level, list);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            hashMap.put(level, list);
        }
//        hashMap.putIfAbsent(level, new ArrayList<>());
//        hashMap.get(level).add(root.data);

        // No need to print
//        System.out.println(root.data);
        preOrderTraversal(root.left, level+1, hashMap);
        preOrderTraversal(root.right, level+1, hashMap);
    }

    // Recursive traversal and printing
    public static void printLevelOrderTraversal_usingHashMap(TreeNode root) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to their level
        preOrderTraversal(root, 1, hashMap);

        // iterate through the map and print all nodes between given levels
        hashMap.forEach((key, value) -> {
            System.out.println("Elements for level: "+key);
            value.stream().forEach(listValue -> System.out.println(listValue));
        });
    }
}
