package february.week2;

import utils.TreeNode;

public class Day2_ConvertBSTToGreaterTree {
    int greaterNodeSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val = root.val + greaterNodeSum;
        greaterNodeSum = root.val;
        convertBST(root.left);
        return root;
    }
}
