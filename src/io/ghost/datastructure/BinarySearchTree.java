package io.ghost.datastructure;

public class BinarySearchTree {

    // Searching
    public static boolean searchBT(TreeNode root, int num) {
        if (root == null) return false;

        if (root.data == num) return true;

        if (root.data > num) {
            return searchBT(root.left, num);
        } else {
            return searchBT(root.right, num);
        }
    }

    // Insertion
    // Find the element position and insert then return
    public static TreeNode insertNodeInBST(TreeNode root, int num) {
        if (root ==  null) {
            TreeNode node = new TreeNode(num);
            return root = node;
        }
        if (root.data < num) {
            return root.right = insertNodeInBST(root.left, num);
        } else {
            return root.left = insertNodeInBST(root.right, num);
        }
    }

    //Delete a node from Binary Search Tree
    public static TreeNode delete(TreeNode root, int num) {
        if (root == null) return root;

        if (root.data < num) {
            root.left = delete(root.right, num);
        } else if(root.data > num){
            root.right = delete(root.left, num);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // here we are trying to find the minimum node data from right sub-tree. Also we can do
            // we can find the maximum node data from left subtree. Any one sub-tree we can take.
            // Here we are taking right sub-tree
            int data = minValue(root.right);
            root.right = delete(root, data);
        }

        return root;
    }

    public static int minValue(TreeNode root) {
        TreeNode node = root.left;
        int data = root.data;

        while (node != null) {
            data = node.data;
            node = node.left;
        }
        return data;
    }

    // Check if the Tree is Binary Tree or Not
    // This is not the optimized solution. The time complexity is O(n2). Because we are trying to find maximum node from
    // left subtree and minimum node from right subtree for every Node. If left Node (returned) is the lesser than current
    // Node and right node (return via recursion) is greater than that of current node. Then Tree is balanced.

    // Auxiliary Space: O(h)
    //
    //Here h is the height of the tree and the extra space is used due to function call stack.
    public static int checkBinaryTree_V1(TreeNode root) {
        if (root == null) return 1;
        int rightData = maxValue(root.right);

        // Returns false
        if (root.left != null && root.data < minValue(root.left)) {
            return 0;
        }
        if (root.right != null && root.data > maxValue(root.right))
            return 0;

        // check the recursively if left and right subtree is NOT BT.
        if (checkBinaryTree_V1(root.left) ==0  && checkBinaryTree_V1(root.right) == 0)
            return 0;

        return 1;
    }

    // trying to find the maximum value from BT
    public static int maxValue(TreeNode root) {
        TreeNode node = root.right;
        int data = root.data;
        while (node != null) {
            data = node.data;
            node = node.right;
        }
        return data;
    }

    // This logic is efficient.
    // A better solution looks at each node only once. The trick is to write a utility helper
    // function isBSTUtil(TreeNode node, int min, int max) that traverses down the tree keeping track of the
    // narrowing min and max allowed values as it goes, looking at each node only once. The initial values
    // for min and max should be INT_MIN and INT_MAX — they narrow from there.
    //
    //Note: This method is not applicable if there are duplicate elements with value INT_MIN or INT_MAX.
    public static boolean checkBinaryTree_V2(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(TreeNode root, int min, int max) {
        // Since an empty binary tree or one node Binary tree is also a binary tree
        if (root == null) return true;

        if (min > root.data && max < root.data) {
            return false;
        }

        // Not that this && (AND) condition is very important!!! If u give OR condition then everytime u will get TRUE
        return (isBSTUtil(root.left, min, root.data - 1) &&
                isBSTUtil(root.right, root.data + 1, max));
    }
}
