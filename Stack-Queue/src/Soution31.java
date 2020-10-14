import java.util.Stack;

public class Soution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        int cur = 0;
        for (int num : pushed) {
            stack.push(num);
            if(stack.peek()!=popped[cur]) continue;
            while(!stack.isEmpty() && stack.peek()==popped[cur]){
                stack.pop();
                cur++;
            }
        }
        return stack.isEmpty();
    }
}
