package april.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preorderIterative(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Stack<Node> stk = new Stack();
        stk.push(root);

        while (!stk.isEmpty()) {
            Node node = stk.pop();
            res.add(node.val);
            int i=node.children.size() - 1;
            for (; i>=0; i--) {
                if (node.children.get(i) != null) {
                    stk.push(node.children.get(i));
                }
            }
        }
        return res;
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
