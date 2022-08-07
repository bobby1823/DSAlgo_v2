package io.ghost.datastructure;

public class ConvertBTree_DoubleLinkedList {

    static TreeNode prev = null;
    static TreeNode head = null;

    // Without using extra space
    public static void convertBinaryTreeToLinkedList(TreeNode root) {
        if (root == null) return;

        // using In Order traversal
        convertBinaryTreeToLinkedList(root.left);

        // Operation to change prev node to current Node and making current node point to prev node
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        // this is set because of In order traversal.. first we traverse till  then L-N-R
        prev = root;
        convertBinaryTreeToLinkedList(root.right);
    }
}
