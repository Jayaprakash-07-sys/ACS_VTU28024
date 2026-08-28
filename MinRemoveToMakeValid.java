import java.util.*;

class Solution {
    public String MinRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        // Find unmatched parentheses
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c == '(') {
                stack.push(i);
            } 
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } 
                else {
                    // Mark unmatched ')' for removal
                    sb.setCharAt(i, '*');
                }
            }
        }

        // Mark remaining unmatched '(' for removal
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // Build the final answer
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}