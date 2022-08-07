package io.ghost.datastructure;

import java.util.*;

public class BottomView_BinaryTree {

    public static void getBottomView(TreeNode root) {

        traverseInTree_using_levelOrder(root);

    }


    // Using LEVEL Order Traversal
    // If element is already present in TreeMap, just replace it.. no need to skip
    public static void traverseInTree_using_levelOrder(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        // Stores the key as horizontal distance and value as value of node
        Map<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();

            // If element is already present in TreeMap, just replace it.. no need to skip
            map.put(currentPair.hd, currentPair.node.data);

            if (currentPair.node.left != null)
                queue.add(new Pair(currentPair.hd - 1 , currentPair.node.left));

            if (currentPair.node.right != null)
                queue.add(new Pair(currentPair.hd + 1 , currentPair.node.right));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        map.forEach((key, value) -> {
            arrayList.add(value);
        });

        System.out.println(arrayList);
    }

    // Static class to store the Node and its corresponding Horizontal distance
    static class Pair {
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
