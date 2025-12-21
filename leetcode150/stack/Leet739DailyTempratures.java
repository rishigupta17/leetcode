package stack;

import java.util.Arrays;
import java.util.Stack;

public class Leet739DailyTempratures {

    public static void main(String[] args) {
        Leet739DailyTempratures solution = new Leet739DailyTempratures();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,60,90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ) {
                    result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
