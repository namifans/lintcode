public class Solution {
    /**
    * @param s: a string
    * @return: an integer 
    */
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int len = s.length(), result = 0, j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && hash[(int) s.charAt(j)] == 0) {
                result = Math.max(j - i + 1, result);
                hash[(int) s.charAt(j++)] = 1;
            }
            hash[(int) s.charAt(i)] = 0;
        }
        return result;
    }
}