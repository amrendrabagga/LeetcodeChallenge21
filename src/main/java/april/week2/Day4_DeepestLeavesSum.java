package april.week2;

import utils.TreeNode;

public class Day4_DeepestLeavesSum {
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int height = findHeight(root);
        calculateLeafSum(root, 1, height);
        return sum;
    }

    private void calculateLeafSum(TreeNode root, int level, int height) {
        if (root == null) {
            return;
        }
        if (level == height) {
            sum += root.val;
        }
        calculateLeafSum(root.left, level + 1, height);
        calculateLeafSum(root.right, level + 1, height);
    }
    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
