package io.ghost.datastructure;

import java.util.*;
import java.util.LinkedList;

public class TopView_BinaryTree {

    public static void getTopView(TreeNode root) {

//        traverseInTree_using_levelOrder(root);
        topView(root);

    }


    // Note that this method of traversal is wrong. Need to avoid IN/PRE/POST ORDER TRAVERSAL
    // We need to do LEVEL ORDER TRAVERSAL
    public static void traverseInTree_using_preOrder(TreeNode root, int distance, TreeMap map) {
        if (root == null) return;

        // using Preorder traversal
        if (!map.containsKey(distance)) map.put(distance, root.data);
        traverseInTree_using_preOrder(root.left, distance - 1, map);
        traverseInTree_using_preOrder(root.right, distance + 1, map);
    }

    // Using LEVEL Order Traversal
    public static void traverseInTree_using_levelOrder(TreeNode root) {
       Queue<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(0, root));

       // Stores the key as horizontal distance and value as value of node
       Map<Integer, Integer> map = new TreeMap<>();
       while (!queue.isEmpty()) {
           Pair currentPair = queue.poll();
           if (!map.containsKey(currentPair.hd)) map.put(currentPair.hd, currentPair.node.data);

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


    public static ArrayList<Integer> topView(TreeNode root)
    {

        // add your code
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        queue.add(null);
        map.put(0, root.data);
        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current == null) {
                if (queue.isEmpty())
                    break;
                queue.add(null);
                // System.out.println();
            } else {
                // System.out.println(current.node.data);
                if (current.node.left != null) {
                    if (map.get(current.hd-1) == null) {
                        map.put(current.hd - 1, current.node.left.data);
                    }
                    queue.add(new Pair(current.hd - 1, current.node.left));
                }
                if (current.node.right != null) {
                    if (map.get(current.hd + 1) == null) {
                        map.put(current.hd + 1, current.node.right.data);
                    }
                    queue.add(new Pair(current.hd + 1, current.node.right));
                }
            }

        }
        map.forEach((k, v) -> {
            list.add(v);
        });
        return list;
    }
}
