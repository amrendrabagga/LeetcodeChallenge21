package march.week2;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day2_AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (level + 1 < d) {
            Queue<TreeNode> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            queue = tmp;
            level++;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = new TreeNode(v);
            node.left.left = tmp;

            tmp = node.right;
            node.right = new TreeNode(v);
            node.right.right = tmp;
        }
        return root;
    }
}
