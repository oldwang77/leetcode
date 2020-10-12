public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
