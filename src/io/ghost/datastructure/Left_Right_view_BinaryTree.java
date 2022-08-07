package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Left_Right_view_BinaryTree {

    // This method uses Queue approach, where we traverse all the nodes and store in Queue. One trick is here we track the node
    // level change via maintaining a null element after level change. and when ever level is changed we change the lvlChanged
    // boolean attribute to true.
    public static void printLeftViewBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean lvlChanged = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
               if (queue.isEmpty()) return;
               queue.add(null);
               lvlChanged = true;
            } else {
                if (lvlChanged) System.out.println(node.data);

                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null)
                    queue.add(node.right);

                lvlChanged = false;
            }

        }
    }

    // Unlike previous method, there we do not traverse all the nodes. using HashMap
    public static void printLeftMostView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        traverseAndStoreInMap(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    public static void printRightMostView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        traverseAndStoreInMap_reverse_preorder(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    private static void traverseAndStoreInMap(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) return;

        if (!map.containsKey(level)) map.put(level, root.data);
        traverseAndStoreInMap(root.left, level + 1, map);
        traverseAndStoreInMap(root.right, level + 1, map);
    }

    private static void traverseAndStoreInMap_reverse_preorder(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) return;

        if (!map.containsKey(level)) map.put(level, root.data);
        traverseAndStoreInMap_reverse_preorder(root.right, level + 1, map);
        traverseAndStoreInMap_reverse_preorder(root.left, level + 1, map);
    }

}

