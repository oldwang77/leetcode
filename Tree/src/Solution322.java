import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 逐层打印二叉树，就是要记录结点的层信息
 */
public class Solution322 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lsts = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();

        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();

            // 每一次遍历，que.size里面放的都是同一层的node
            // 这样写是错误的，因为que.size在发生变化
            // for (int i = 0; i < que.size(); i++) {
            int size = que.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = que.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            lsts.add(tmp);
        }
        return lsts;
    }
}
