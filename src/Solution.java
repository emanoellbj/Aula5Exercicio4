import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String input1 = "(){[()]}";
        System.out.println(solution.isValid(input1));

        String input2 = "()[]{}";
        System.out.println(solution.isValid(input2));

        String input3 = "(]";
        System.out.println(solution.isValid(input3));

        String input4 = "[{}())";
        System.out.println(solution.isValid(input4));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}