package january.week3;

import java.util.Stack;

public class Day6_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        for (char c : s.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(c);
            }
            else {
                char t = stk.peek();
                if (c == ')' && t == '(') {
                    stk.pop();
                }
                else if (c == '}' && t == '{') {
                    stk.pop();
                }
                else if (c == ']' && t == '[') {
                    stk.pop();
                }
                else {
                    stk.push(c);
                }
            }
        }
        System.out.println(stk);
        return stk.isEmpty();
    }

    public boolean isValidEfficient(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Day6_ValidParentheses obj = new Day6_ValidParentheses();
        System.out.println(obj.isValid("()[]{}"));

    }
}
