import java.util.ArrayList;
import java.util.LinkedList;

public class Solution68 {
    /**
     * 思路，从root出发，遍历经过p和q的路径，查找这两条路径相交的位置
     * @param root
     * @param p
     * @param q
     * @return
     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        // 保存访问p和q的两条路径
        LinkedList<TreeNode> lstp = new LinkedList<>();
        LinkedList<TreeNode> lstq = new LinkedList<>();

        findPath(root,p,lstp);
        findPath(root,q,lstq);

        int n = Math.min(lstp.size(),lstq.size());

        TreeNode treeNode = null;
        for(int i=0;i<n;i++){
            // 返回最后一次相同的结点，就是二叉树最近的祖先
            if(lstp.get(i)==lstq.get(i)){
                treeNode = lstp.get(i);
            }
        }
        return treeNode;
    }

    public void findPath(TreeNode root,TreeNode node,LinkedList lst){
        if(root==null) return ;
        lst.add(root);

        if(lst.getLast()!=node) findPath(root.left,node,lst);
        if(lst.getLast()!=node) findPath(root.right,node,lst);
        // 反溯
        if(lst.getLast()!=node) lst.removeLast();
    }
}
