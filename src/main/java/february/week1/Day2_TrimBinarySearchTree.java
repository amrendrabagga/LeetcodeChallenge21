package february.week1;

import utils.TreeNode;

public class Day2_TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // we have to reject values that are > high and < low
        // so we check at each node whether root.val > high then search left subtree
        // and if root.val < l then search right subtree
        // if in range then we just recursively assing left and right
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        else if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
