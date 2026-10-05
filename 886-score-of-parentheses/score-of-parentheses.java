class Solution {
    public int scoreOfParentheses(String s) {
        // Stack to hold scores at each level
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // initial score

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Start a new frame
                stack.push(0);
            } else {
                // End of a frame
                int v = stack.pop();
                int top = stack.pop();
                // If v == 0, it was "()", so score = 1
                // Otherwise, score = 2 * v
                stack.push(top + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
