import java.util.Deque;
import java.util.LinkedList;

/**
 * 数组nums，维护一个窗口大小为k的最大值
 */
public class Solution59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 双端队列[i,j]
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // i=0这个窗口不需要删除元素
            // 只有i>0时候，窗口滑动才会删除元素
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                // 删除deque中对应的nums[i-1]
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                //保证deque是递减的
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                //记住窗口的最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
