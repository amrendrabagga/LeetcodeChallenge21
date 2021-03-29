package march.week5;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day1_FlipBinaryTreeToMatchPreorderTraversal {
    private int index;
    private List<Integer> flipped;
    private int voyage[];
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        flipped = new ArrayList<>();
        this.voyage = voyage;
        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }
            // if root val are same then check left and right value
            if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
                flipped.add(root.val);
                dfs(root.right);
                dfs(root.left);
            }
            else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
