public class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double ans = 1.0;
        long b = n;         // 防止越界，先用long存储

        // 先考虑负数
        if (b < 0) {
            x = 1 / x;
            b = -b;     // -b>0
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            b = b >> 1;
        }
        return ans;
    }
}
