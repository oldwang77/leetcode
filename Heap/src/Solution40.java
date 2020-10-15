import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) return vec;

        PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 将数组前k个加入优先队列
        for (int i = 0; i < k; i++) {
            que.add(arr[i]);
        }
        // 随后从第 k+1k+1 个数开始遍历，如果当前遍历到的数比大根堆的堆顶的数要小，
        // 就把堆顶的数弹出，再插入当前遍历到的数。
        for (int i = k; i < arr.length; i++) {
            if (que.peek() > arr[i]) {
                que.poll();         // 弹出堆顶元素
                que.add(arr[i]);    // 加入新的元素
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = que.poll();
        }

        return vec;
    }
}
