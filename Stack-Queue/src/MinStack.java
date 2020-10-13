import java.util.Stack;

/**
 * stack1存储元素，stack2的栈顶放stack1里面最小的元素
 */
class MinStack {

    Stack<Integer> stack1,stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

        if(stack2.isEmpty() || stack2.peek()>=x){
            stack2.push(x);
        }
    }

    public void pop() {
        // if(stack2.peek()==stack1.peek()){
        //     stack2.pop();
        // }
        // stack1.pop();
        /**
         * 此题如果用==将会无法通过 Integer的equals重写过，
         * 比较的是内部value的值， ==如果在[-128,127]会被cache缓存,
         * 超过这个范围则比较的是对象是否相同
         */
        if(stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}