public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        if (s == null || s.length() < 3)
            return s;
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (']' == c) {
                StringBuilder str = new StringBuilder();
                while (!stack.empty() && stack.peek().length() > 0 
                    && Character.isLetter(stack.peek().charAt(0))) {
                    str.insert(0, stack.pop());
                }
                if (!stack.empty() && "[".equals(stack.peek())) {
                    stack.pop();
                }
                int count = 0;
                if (!stack.empty() && stack.peek().length() > 0 
                    && Character.isDigit(stack.peek().charAt(0))) {
                    count = Integer.parseInt(stack.pop());
                }
                StringBuilder newStr = new StringBuilder();
                if (count != 0) {
                    while (count-- > 0) {
                        newStr.append(str.toString());
                    }
                    stack.push(newStr.toString());
                }
            } else if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i + 1)))
                    i++;
                stack.push(s.substring(start, i + 1));
            } else {
                stack.push("" + c);
            }
        }
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}