package binarytree;

/**
 * Problem (236)
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;

        return dfs(root, p, q);
    }

    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;
        // we hit leaf and we didint found node, return null
        if (root.left == null && root.right == null) return null;

        // recursive case
        TreeNode leftLCA = dfs(root.left, p, q);
        TreeNode rightLCA = dfs(root.right, p, q);

        if (leftLCA == null) return rightLCA;
        if (rightLCA == null) return leftLCA;

        return root;
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        //          3
        //        /   \ 
        //       5     1
        //      / \   / \
        //     6   2  0  8
        //        / \
        //       7   4
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = p;
        root.right = q;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println("Lowest common ancestor is: " + lowestCommonAncestor(root, p, q).val);

        // Constructing the binary tree
        //          1
        //        /   \ 
        //       2     3
        //      / \   / \
        //     4   5  6  7
        //        / \
        //       8   9
        TreeNode x = new TreeNode(2);
        TreeNode y = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = x;
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(8);
        root2.left.right.right = new TreeNode(9);

        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.right = y;

        System.out.println("Lowest common ancestor is: " + lowestCommonAncestor(root2, x, y).val);

        // Constructing the binary tree
        //          1
        //        /   \ 
        //       2     3
        //      / \   / \
        //     4   5  6  7
        //        / \
        //       8   9
        TreeNode w = new TreeNode(4);
        TreeNode z = new TreeNode(9);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = w;
        root3.left.right = new TreeNode(5);
        root3.left.right.left = new TreeNode(8);
        root3.left.right.right = z;

        root3.right = new TreeNode(3);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(7);

        System.out.println("Lowest common ancestor is: " + lowestCommonAncestor(root3, w, z).val);
    }
}
