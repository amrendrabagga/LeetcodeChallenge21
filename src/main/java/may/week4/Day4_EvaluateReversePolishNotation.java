package may.week4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Day4_EvaluateReversePolishNotation {
    Set<String> set = new HashSet(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        for (String s : tokens) {
            if (!set.contains(s)) {
                stk.push(Integer.parseInt(s));
            }
            else {
                int b = stk.pop();
                int a = stk.pop();
                int c = calculate(a, b, s);
                stk.push(c);
            }
        }
        return stk.isEmpty() ? 0 : stk.pop();
    }
    private int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
