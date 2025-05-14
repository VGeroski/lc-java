package binarytree;

/**
 * Problem (104):
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */
public class MaximumDepthBinaryTree {
    
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE; // invalid path - minus inf
        if (root.left == null && root.right == null) return 1; // leaf node

        int left = dfs(root.left);
        int right = dfs(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        //          10
        //        /    \ 
        //       11     9
        //      /      / \
        //     7      15   8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println("Maximal depth of binary tree is: " + maxDepth(root));

        root.right.right.left = new TreeNode(6);
        System.out.println("Maximal depth of binary tree is: " + maxDepth(root));
    }
}