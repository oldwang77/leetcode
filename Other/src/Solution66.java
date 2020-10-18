public class Solution66 {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        // 从左向右扫描，不包括当前自己
        int cur = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = cur;
            cur = cur * a[i];
        }
        // 从右向左扫描，不包括自己
        cur = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] = res[i] * cur;
            cur = cur * a[i];
        }

        return res;
    }
}
