import java.util.*;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove temperatures that are not warmer
            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If stack is not empty, top is the next warmer day
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }

            // Store current day's index
            stack.push(i);
        }

        return answer;
    }
}