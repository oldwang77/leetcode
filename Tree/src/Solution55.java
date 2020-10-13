public class Solution55 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

}
