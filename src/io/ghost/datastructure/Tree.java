package io.ghost.datastructure;

import java.util.Scanner;

import static io.ghost.datastructure.BinarySearchTree.*;
import static io.ghost.datastructure.BottomView_BinaryTree.getBottomView;
import static io.ghost.datastructure.BurnBinaryTree_from_Leaf_Node.burnTime;
import static io.ghost.datastructure.DiameterOfBinaryTree.diameterOfBT;
import static io.ghost.datastructure.FloorValue_CellValue_BinaryTree.floorValue_V1;
import static io.ghost.datastructure.FloorValue_CellValue_BinaryTree.floorValue_V2;
import static io.ghost.datastructure.Left_Right_view_BinaryTree.*;
import static io.ghost.datastructure.LevelOrderTraversalBT.printCurrentLevelV2;
import static io.ghost.datastructure.LevelOrderTraversalBinaryTree_HashMap.printLevelOrderTraversal_usingHashMap;
import static io.ghost.datastructure.LowestCommonAncestorBinaryTree.lowestCommonAncestor_V1;
import static io.ghost.datastructure.Pair_BinaryTree_TwoSum.checkIfPairPresent;
import static io.ghost.datastructure.SizeBTree_MaxMin.maxInBinaryTree;
import static io.ghost.datastructure.SizeBTree_MaxMin.sizeOfBinaryTree;
import static io.ghost.datastructure.TopView_BinaryTree.getTopView;
import static io.ghost.datastructure.VerticalOrderTraversal.verticalOrderTraversal;

/**
 * Create a binary Tree using recursion
 */
public class Tree {

    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        TreeNode root = createTree();
//        preOrderTraversal(root);
        postOrderTraversal(root);
//        printRightMostView(root);
//        getTopView(root);
//        getBottomView(root);
//        System.out.println("Diameter of B Tree: " +diameterOfBT(root));
//        lowestCommonAncestor_V1(root, 1, 3);
//        System.out.println("Minimum time to burn the tree: "+ burnTime(root, new Depth(-1), 6));
//        System.out.println("Number found in Binary Tree: " +searchBT(root, 2));
//        insertNodeInBST(root, 5);
//        System.out.println("Entire BT after insertion: " +root);
//        System.out.println("Binary Tree is valid: " +checkBinaryTree_V2(root));
//        System.out.println("Floor Value of Binary Tree: " +floorValue_V1(root, 4));
//        System.out.println("Floor Value of Binary Tree: " +floorValue_V2(root, 7));
//        System.out.println("Two Sum exist in Binary Tree: "+ checkIfPairPresent(root, 150));
//        verticalOrderTraversal(root);
//        printLeftViewBinaryTree(root);
//        printLeftMostView(root);
//        System.out.println(heightOfBT(root));
//        System.out.println("Size of Binary Tree: " + sizeOfBinaryTree(root));
//        System.out.println("Maximum integer in Binary Tree: " + maxInBinaryTree(root));
//        printCurrentLevelV2(root);
        // print using hashmap and inorder traversal of Binary Tree
//        printLevelOrderTraversal_usingHashMap(root);
    }

    static TreeNode createTree() {
        TreeNode root = null;
        System.out.println("Enter the data");
        int data = sc.nextInt();
        if (data == -1) return null;

        root = new TreeNode(data);

        System.out.println("Enter the left for data: " +data);
        // Recursion.. leap of faith. Automatically the sc.nextInt will get called and further operations will happen
        root.left = createTree();

        System.out.println("Enter the right for data: " +data);
        root.right = createTree();

        return root;
    }

    public static int heightOfBT(TreeNode root) {
        int count1 = 0;
        int count2 = 0;
        if (root == null) return 0;
        count1 += heightOfBT(root.left) + 1;

        count2 += heightOfBT(root.right) + 1;
        return count1 > count2 ? count1 : count2;
    }

    // L-N-R = Left print then node then right
    static void inOrderTraversal(TreeNode root) {

        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    // N-L-R = Node print then Left then right
    static void preOrderTraversal(TreeNode root) {

        if (root == null) return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // L-R-N = Node print then Left then right
    static void postOrderTraversal(TreeNode root) {

        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode (int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
