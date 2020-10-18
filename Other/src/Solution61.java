import java.util.*;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        // 0 0 可以看作任何数字
        int minn = 14, maxx = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            maxx = Math.max(maxx, num);
            minn = Math.min(minn, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return maxx - minn < 5;
    }
}
