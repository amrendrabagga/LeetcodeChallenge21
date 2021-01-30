package january.week5;

import utils.TreeNode;

import java.util.*;

public class Day1_VerticalOrderTraversalOfBinaryTree {
    static class VerticalNode implements Comparable<VerticalNode> {
        TreeNode node;
        int x;// represents x coordinate
        int level;// represents level in tree level
        VerticalNode(TreeNode node, int x, int level) {
            this.node = node;
            this.x = x;
            this.level = level;
        }

        @Override
        public int compareTo(VerticalNode o) {
            if (this.level == o.level) {
                return this.node.val - o.node.val;
            }
            return this.level - o.level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        PriorityQueue<VerticalNode> queue = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.offer(new VerticalNode(root, 0, 0));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                VerticalNode verticalNode = queue.poll();
                map.putIfAbsent(verticalNode.x, new LinkedList<>());
                map.get(verticalNode.x).add(verticalNode.node.val);

                if (verticalNode.node.left != null) {
                    queue.offer(new VerticalNode(verticalNode.node.left, verticalNode.x - 1, level + 1));
                }
                if (verticalNode.node.right != null) {
                    queue.offer(new VerticalNode(verticalNode.node.right, verticalNode.x + 1, level + 1));
                }
            }
            level++;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : map.values()) {
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        Day1_VerticalOrderTraversalOfBinaryTree obj = new Day1_VerticalOrderTraversalOfBinaryTree();
        System.out.println(obj.verticalTraversal(root));
    }
}
