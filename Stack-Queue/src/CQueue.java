import java.util.Stack;

class CQueue {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()) return -1;

        // 1 将stack1的内容全部转移到stack2中
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // 2 记录stack2的栈顶元素
        int tmp = stack2.pop();

        // 3 将stack2的元素返回到stack1中
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return tmp;
    }
}
