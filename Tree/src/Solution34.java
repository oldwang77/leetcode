import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    LinkedList<List<Integer>> lists = new LinkedList<>();
    LinkedList<Integer> lst = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return lists;
    }
    public void dfs(TreeNode node,int sum){
        if(node==null) return ;
        lst.add(node.val);
        sum = sum - node.val;
        if(sum==0&&node.left==null&&node.right==null){
            lists.add(new LinkedList<>(lst));
        }
        dfs(node.left,sum);
        dfs(node.right,sum);
        //递归结束时，该留的路径已经记录了，不符合的路径也都不用理，删掉当前路径节点的值
        lst.removeLast();
    }
}
