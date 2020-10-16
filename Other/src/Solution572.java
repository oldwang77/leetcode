import java.util.ArrayList;

/**
 * 规定滑动窗口的左右只能向右边移动
 */
public class Solution572 {
    public int[][] findContinuousSequence(int target) {
        //[i,j)，左闭右开，开始是一个区间大小为0
        int i = 1, j = 1, sum = 0;
        ArrayList<int[]> lst = new ArrayList<>();

        while (i <= target / 2) {

            if (sum == target) {
                int[] arr = new int[j-i];
                // 注意，为了编程的方便，滑动窗口一般表示成一个左闭右开区间。
                // 在一开始，i=1, j=1i=1,j=1，滑动窗口位于序列的最左侧，窗口大小为零。

                for (int q = i; q <j; q++) {
                    arr[q-i] = q;
                }
                lst.add(arr);
                // 左边向右滑动
                sum -= i;
                i++;

            } else if (sum > target) {
                // 左窗口向右滑动
                sum = sum - i;
                i++;
            } else {
                sum = sum + j;
                j++;
            }
        }
        return lst.toArray(new int[lst.size()][]);
    }
}
