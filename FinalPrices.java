import java.util.*;

public class FinalPrices {

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = prices.clone();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Find the first previous price that is >= current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {

                int index = stack.pop();

                answer[index] = prices[index] - prices[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};

        int[] result = finalPrices(prices);

        System.out.println(Arrays.toString(result));
    }
}