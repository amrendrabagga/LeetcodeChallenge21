package april.week3;

import java.util.ArrayList;
import java.util.List;

public class Day6_NArrayTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        dfs(root, res);
        return res;
    }
    private void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            dfs(node, res);
        }
    }
    private static class Node {
        int val;
        List<Node> children;

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
