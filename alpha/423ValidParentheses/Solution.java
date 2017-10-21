public class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if (s == null)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ')') {
                if (stack.empty() || '(' != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else if (str[i] == '}') {
                if (stack.empty() || '{' != stack.peek()) {
                    return false;
                } 
                stack.pop();
            } else if (str[i] == ']') {
                if (stack.empty() || '[' != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}