public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int ss = (int) s.charAt(i);
            int ts = (int) t.charAt(i);
            if (sMap[ss] == 0 && tMap[ts] == 0) {
                sMap[ss] = ts;
                tMap[ts] = 1;
            } else {
                if (sMap[ss] != ts)
                    return false;
            }
        }
        return true;
    }
}