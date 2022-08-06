package io.ghost.datastructure;

public class BurnBinaryTree_from_Leaf_Node {


    public static int ans = 0;


    /**
     * NLR Traversal
     * Here we will try to find the height of opposite sub-tree where we didn't found the leaf node which was supposed to be burned.
     * and we will try to find the depth of that burnt leaf from the current node.
     * This will be done for every node and the maximum of the value will be our answer.
     *
     *  ans = Math.max(ans, d(this is the depth of burnt leave) + left/right subtree height)
     *
     *  Here We are using depth as Depth custom class so that our depth Object is accessible and value is not lost on recursion.
     *  Because of Objects are call by reference.
     */
    public static int burnTime(TreeNode root, Depth depth, int num) {
        if (root == null) return 0;

        if (root.data == num) {
            depth.d = 0;
            return 1;
        }
        Depth leftDepth = new Depth(-1);
        Depth rightDepth = new Depth(-1);
        int left = burnTime(root.left, leftDepth, num);
        int right = burnTime(root.right, rightDepth, num);

        // Some Operation
        if (leftDepth.d != -1) {
            depth.d = leftDepth.d + 1;
            ans = Math.max(ans, depth.d + right);
        } else if (rightDepth.d != -1) {
            depth.d = rightDepth.d + 1;
            ans = Math.max(ans, depth.d + left);
        }

        return Math.max(left, right) + 1;
    }

}

class Depth {

    int d;
    public Depth(int d) {
        this.d = d;
    }
}
