package stack;

import java.util.List;
import java.util.Stack;

public class Leet150PolishNotation {

    public static void main(String[] args) {
        Leet150PolishNotation notation = new Leet150PolishNotation();
        System.out.println(notation.evalRPN(List.of("2","1","+","3","*").toArray(new String[0])));
        System.out.println(notation.evalRPN(List.of("4","13","5","/","+").toArray(new String[0])));
        System.out.println(notation.evalRPN(List.of("10","6","9","3","+","-11","*","/","*","17","+","5","+").toArray(new String[0])));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(operate(a,b,token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
    private int operate(int a, int b, String operator) {
        switch (operator) {
            case "*":
                return b*a;
            case "/":
                return b/a;
            case "+":
                return b+a;
            case "-":
                return b-a;
            default:
                return 0;
        }
    }
}
