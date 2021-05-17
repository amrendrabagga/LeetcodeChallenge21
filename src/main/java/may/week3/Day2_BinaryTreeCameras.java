package may.week3;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Day2_BinaryTreeCameras {
    int cam;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        cam = 0;
        covered = new HashSet();
        // not place camera at leaf node
        covered.add(null);
        dfs(root, null);
        return cam;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root != null) {
            // starting from bottom
            dfs(root.left, root);
            dfs(root.right, root);

            if (parent == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right)) {
                cam++;
                covered.add(root);
                covered.add(parent);
                covered.add(root.left);
                covered.add(root.right);
            }
        }
    }

    public int minCameraCoverEfficient(TreeNode root) {
        cam = 0;
        int ans = dfs(root);
        System.out.println(ans);
        return ans == 0 ? cam + 1 : cam;
    }
    // 0 -> not covered by camera
    // 1 -> partially covered by camera
    // 2 -> camera is present at node
    private int dfs(TreeNode root) {
        if (root == null) {
            // we dont place camera at leaf, thus partially covered
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            // place camera to cover either left or right child
            cam++;
            return 2;
        }
        if (left == 2 || right == 2) {
            // camera is placed at child thus current node is partially covered
            return 1;
        }
        return 0;
    }
}
