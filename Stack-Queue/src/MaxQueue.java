import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {

    // 记录最大值
    LinkedList<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        // deque是双端队列，记录最大的元素
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return deque.size()==0?-1:deque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(deque.size()!=0 && deque.getLast()<value){
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        //Integer类型的值的比较不能直接使用==
        if(deque.size()!=0 && queue.peek().equals(deque.getFirst())){
            deque.removeFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */