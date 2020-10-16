import java.util.LinkedList;
import java.util.Queue;

public class Solution37 {
    // Encodes a tree to a single string.
    // [1,2,3,null,null,4,5]
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                res.append(node.val + ",");
                que.add(node.left);
                que.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);   // 删除尾部'，'
        res.append("]");
        return res.toString();
    }


    // Decodes your encoded data to tree.
    // [1,2,3,null,null,4,5]
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        // substring范围[1,data.length()-1)，去掉了[]括号
        String[] ss = data.substring(1, data.length() - 1).split(",");
        // 建立root结点
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int i = 1;       //root已经在队列了，从1开始
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            // 左子树不为空的话，加入左子树
            if (i<ss.length && !ss[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(ss[i]));
                que.add(node.left);
            }
            i++;
            // 右子树不为空的话，加入右子树
            if (i<ss.length && !ss[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(ss[i]));
                que.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution37 s = new Solution37();
        TreeNode node = s.deserialize("[1,2,3,null,null,4,5]");

    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
