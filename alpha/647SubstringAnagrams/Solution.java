public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] target = new int[26];
        int[] source = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            source[s.charAt(j) - 'a']++;
            if (j - i + 1 < p.length()) {
                j++;
                continue;
            }
            if (checkAnagram(target, source)) {
                result.add(i);
            }
            source[s.charAt(i) - 'a']--;
            i++;
            j++;
        }
        return result;
    }

    private boolean checkAnagram(int[] target, int[] source) {
        for (int i = 0; i < 26; i++) {
            if (target[i] != source[i]) {
                return false;
            }
        }
        return true;
    }
}