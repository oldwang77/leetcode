public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder,int left,int right){
        if(left>=right) return true;
        // 找到第一个大于右端的点
        int p =left;
        while(postorder[p]<postorder[right]){
            p++;
        }
        int m = p;
        while(postorder[p]>postorder[right]){
            p++;
        }
        /**
         * p == right   判断此树是否正确
         * recur(postorder,left,m-1)  左子树
         * recur(postorder,m,right-1) 右子树。根在上一次确定了，所以right-1
         */
        return p==right && recur(postorder,left,m-1) && recur(postorder,m,right-1);
    }
}
