package io.ghost.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import static io.ghost.datastructure.HeightOfBinaryTree.heightOfBT;

/**
 * Print all the elements from level wise level..
 *
 */
public class LevelOrderTraversalBT {

    // This will print all the elements in a level.
    public static void printCurrentLevel(TreeNode root, int level) {
        if (root == null) return;

        if (level == 1) {
            System.out.println(root.data);
        }
        if (level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    // Now we need to find the height of tree
    // But the Time Complexity will be O(n2). So, It can be optimized using QUEUE
    public static void printAllLevels(TreeNode root) {
        for (int i = 0; i < heightOfBT(root); i++) {
            printCurrentLevel(root, i);
        }
    }

    /**
     * we are making use of Queue here to decrease the time complexity to O(n) but using extra space
     * @param root
     */
    public static void printCurrentLevelV2(TreeNode root) {
        Queue<TreeNode> queue =  new LinkedList<>();

        queue.add(root);
        // Adding Null in the end of Queue to check and Identify when the level is reached in the
        // Binary Tree
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // checking the null and removing it from the queue starting and putting back in the end
            if (node == null) {
                if (queue.isEmpty()) return;
                queue.add(null);
                System.out.println();
//                node = queue.poll();
            } else {
                System.out.print(node.data);
                // Note that this is very important since we shouldn't feed null values in queue.
                if (queue.isEmpty()) System.out.println();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
