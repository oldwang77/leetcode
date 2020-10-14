import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution323 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lsts = new LinkedList<>();
        LinkedList<TreeNode> lst = new LinkedList<>();
        int mark = 1;

        if (root != null) {
            lst.add(root);
        }

        while (!lst.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = lst.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = lst.poll();

                if (mark == 1) tmp.add(node.val);  // 从前向后添加
                else tmp.addFirst(node.val);     // 从后向前添加
                if (node.left != null) lst.add(node.left);
                if (node.right != null) lst.add(node.right);
            }
            mark = mark * -1;
            lsts.add(tmp);
        }
        return lsts;
    }
}
