public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null)
            return result;
        List<String> current = new ArrayList<>();
        findPalindrome(s, 0, current, result);
        return result;
    }

    private void findPalindrome(String s, int index,
        List<String> current, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (!isPalindrome(substring))
                continue;
            current.add(substring);
            findPalindrome(s, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}