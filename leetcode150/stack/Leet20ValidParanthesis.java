package stack;

import sliding_window.Leet3LongestSub;

import java.util.Stack;

public class Leet20ValidParanthesis {

    public static void main(String[] args) {
        Leet20ValidParanthesis solution = new Leet20ValidParanthesis();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([])"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("]"));
        System.out.println(solution.isValid("]}[{"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(!stack.empty() && ((ch == ')' && stack.peek() == '(')
                    || (ch == '}' && stack.peek() == '{')
                    || (ch == ']' && stack.peek() == '['))) {
                stack.pop();
            } else{
                return false;
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }
}
