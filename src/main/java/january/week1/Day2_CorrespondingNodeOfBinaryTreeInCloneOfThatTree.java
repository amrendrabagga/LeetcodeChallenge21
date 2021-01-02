package january.week1;

import utils.TreeNode;

public class Day2_CorrespondingNodeOfBinaryTreeInCloneOfThatTree {
    TreeNode res = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        getTargetCopyUtils(original, cloned, target);
        return res;
    }

    public final void getTargetCopyUtils(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) return;
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);

        if (cloned.val == target.val && target == original)
            res = cloned;
    }

    public final TreeNode getTargetCopyEfficient(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null)
            return null;
        if (original == target)
            return cloned;

        TreeNode left = getTargetCopyEfficient(original.left, cloned.left, target);
        if (left != null)
            return left;

        TreeNode right = getTargetCopyEfficient(original.right, cloned.right, target);
        if (right != null)
            return right;

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5);
        TreeNode cloned = root;
        Day2_CorrespondingNodeOfBinaryTreeInCloneOfThatTree obj = new Day2_CorrespondingNodeOfBinaryTreeInCloneOfThatTree();
        System.out.println(obj.getTargetCopyEfficient(root, cloned, root.right));

    }
}
