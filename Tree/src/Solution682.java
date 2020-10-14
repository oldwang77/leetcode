// import java.util.ArrayList;
// import java.util.LinkedList;
//
// public class Solution682 {
//     /**
//      * 思路，从root出发，遍历经过p和q的路径，查找这两条路径相交的位置
//      * @param root
//      * @param p
//      * @param q
//      * @return
//      */
//
//
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root==null) return null;
//         // 保存访问p和q的两条路径
//         LinkedList<TreeNode> lstp = new LinkedList<>();
//         LinkedList<TreeNode> lstq = new LinkedList<>();
//
//         findPath(root,p,lstp);
//         findPath(root,q,lstq);
//
//         int n = Math.min(lstp.size(),lstq.size());
//
//         TreeNode treeNode = null;
//         for(int i=0;i<n;i++){
//             // 返回最后一次相同的结点，就是二叉树最近的祖先
//             if(lstp.get(i)==lstq.get(i)){
//                 treeNode = lstp.get(i);
//             }
//         }
//         return treeNode;
//     }
//
//     public void findPath(TreeNode root,TreeNode node,LinkedList lst){
//         if(root==null) return ;
//         lst.add(root);
//
//         if(lst.getLast()!=node) findPath(root.left,node,lst);
//         if(lst.getLast()!=node) findPath(root.right,node,lst);
//         // 反溯
//         if(lst.getLast()!=node) lst.removeLast();
//     }
// }

/**
 * 如果root是null，则说明我们已经找到最底了，返回null表示没找到
 * 如果root与p相等或者与q相等，则返回root
 * 如果左子树没找到，递归函数返回null，证明p和q同在root的右侧，那么最终的公共祖先就是右子树找到的结点
 * 如果右子树没找到，递归函数返回null，证明p和q同在root的左侧，那么最终的公共祖先就是左子树找到的结点
 *
 * 作者：yuanninesuns
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/jian-dan-yi-dong-xiang-jie-ru-xia-by-yuanninesuns/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}























