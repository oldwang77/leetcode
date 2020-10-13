import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution32 {
    // 树的层次遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> que = new LinkedList();
        ArrayList<Integer> lst = new ArrayList<>();

        // 加入头结点
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode fontNode = que.peek();
            que.remove();
            lst.add(fontNode.val);
            if (fontNode.left != null) que.add(fontNode.left);
            if (fontNode.right != null) que.add(fontNode.right);
        }
        int[] arr = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            arr[i] = lst.get(i);
        }
        return arr;
    }
}
