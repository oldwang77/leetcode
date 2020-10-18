import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    Queue<Integer> que1,que2;
    /** initialize your data structure here. */
    public MedianFinder() {
        // que1是小顶堆，保存的数据是较大的那一半
        // que2是大顶堆，保存的数据是较小的那一半
        que1 = new PriorityQueue<>();
        que2 = new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {
        // 确保两个队列里面数据个数差为1
        // 奇数的情况下,que2的size比que1大1
        if(que1.size()==que2.size()){
            que1.add(num);
            que2.add(que1.poll());
        }else{
            que2.add(num);
            que1.add(que2.poll());
        }
    }

    public double findMedian() {
        // 这里要除以2.0，除以2是错的，因为3/2=1！！！要保证是double
        return que1.size()==que2.size()?(que1.peek()+que2.peek())/2.0:que2.peek();
    }
}

public class Solution41{

}

