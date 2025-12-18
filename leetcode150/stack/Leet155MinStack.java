package stack;

import java.util.ArrayList;
import java.util.List;

public class Leet155MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }
}
