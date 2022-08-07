package io.ghost.datastructure;

import java.util.*;

public class VerticalOrderTraversal {

    public static void verticalOrderTraversal(TreeNode root) {

        List<Integer> list = traversal(root);
    }

    private static List<Integer> traversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<BottomView_BinaryTree.Pair> queue = new ArrayDeque<>();
        queue.add(new BottomView_BinaryTree.Pair(0, root));
        // Since TreeMap is sorted. And in TreeMap we will store key as Horizontal Distance.
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();

        while (!queue.isEmpty()) {
            BottomView_BinaryTree.Pair currentPair = queue.poll();

            // If treeMap contains this key then add the node in list
            if (treeMap.containsKey(currentPair.hd)) {
                List list1 = treeMap.get(currentPair.hd);
                list1.add(currentPair.node.data);
                treeMap.put(currentPair.hd, list1);
            } else {
                List list1 = new ArrayList<>();
                list1.add(currentPair.node.data);
                treeMap.put(currentPair.hd, list1);
            }

            // This is for level order traversal
            if (currentPair.node != null && currentPair.node.left != null) {
                queue.add(new BottomView_BinaryTree.Pair(currentPair.hd-1, currentPair.node.left));
            }
            if (currentPair.node != null && currentPair.node.right != null) {
                queue.add(new BottomView_BinaryTree.Pair(currentPair.hd+1, currentPair.node.right));
            }
        }

        treeMap.forEach((k, v) -> {
            v.stream().map(el -> list.add(el));
        });
        return list;
    }
}
