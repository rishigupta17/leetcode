package stack;

import utils.Pair;

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

class MinStack {

    List<Pair> list = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        int min = val;
        if (!list.isEmpty()) {
            min = Math.min(val, topElement().getMin());
        }

        list.add(new Pair(val, min));
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return topElement().getVal();
    }

    public Pair topElement() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return topElement().getMin();
    }
}
