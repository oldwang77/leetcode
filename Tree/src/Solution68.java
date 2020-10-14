public class Solution68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){

            // p和q都在根的右边
            if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
            // p和q都在根的左边
            else if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
            else break;
        }
        // p和q不在同一边，因此返回根结点
        return root;
    }
}
