public class Solution64 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) {
            return 0;
        }
        int minn = 0x7f7f7f;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            minn = Math.min(minn,prices[i]);
            ans = Math.max(ans, prices[i] - minn);
        }
        return ans;
    }
}
