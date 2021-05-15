package may.week2;

import utils.TreeNode;

import java.util.Stack;

public class Day7_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode currentNode = stk.pop();
            if (currentNode.right != null) {
                stk.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stk.push(currentNode.left);
            }
            if (!stk.isEmpty()) {
                currentNode.right = stk.peek();
            }
            currentNode.left = null;
        }
    }

    TreeNode prev;
    public void flattenInMemory(TreeNode root) {
        if (root == null) return;
        flattenInMemory(root.right);
        flattenInMemory(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenUsingMorris(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }


}
