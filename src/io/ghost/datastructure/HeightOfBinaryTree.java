package io.ghost.datastructure;

public class HeightOfBinaryTree {

    public static int heightOfBT(TreeNode root) {
        int count1 = 0;
        int count2 = 0;
        if (root == null) return 0;
        count1 += heightOfBT(root.left) + 1;

        count2 += heightOfBT(root.right) + 1;
        return count1 > count2 ? count1 : count2;
    }
}
