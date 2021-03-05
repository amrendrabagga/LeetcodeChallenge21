package march.week1;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day5_AverageLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int j = size;
            double sum = 0;
            while (j-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum/size);
        }
        return res;
    }

    public static void main(String[] args) {
        Day5_AverageLevelsInBinaryTree obj = new Day5_AverageLevelsInBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), null);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(obj.averageOfLevels(root));

    }
}
