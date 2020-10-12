public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;
        // 当前的A结点 ｜ A的左子树 ｜ A的右子树 满不满足是B是A的子结构
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isSub(TreeNode a,TreeNode b){
        if(b==null) return true;
        if(a==null||a.val!=b.val) return false;
        return isSub(a.left,b.left) && isSub(a.right,b.right);
    }
}
