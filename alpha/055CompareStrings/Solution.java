public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] map = new int[128];
        for (int i = 0; i < A.length(); i++) {
            map[(int) A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            map[(int) B.charAt(i)]--;
            if (map[(int) B.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}