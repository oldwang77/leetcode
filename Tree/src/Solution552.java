import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution552 {
    // bfs遍历整个树
    // depth(root)求左右树的深度，计算差值
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList lst = new ArrayList();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode cur = que.peek();
            que.remove();
            if(depth(cur.left)-depth(cur.right)>1 || depth(cur.left)-depth(cur.right)<-1 ){
                return false;
            }
            if(cur.left!=null) que.add(cur.left);
            if(cur.right!=null) que.add(cur.right);
        }
        return true;
    }

    public int depth(TreeNode node){
        if(node==null) return 0;
        return maxx(depth(node.left),depth(node.right))+1;
    }

    private int maxx(int a, int b) {
        return a>b?a:b;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        Solution552 s = new Solution552();
        System.out.println(s.isBalanced(root));
    }

}
