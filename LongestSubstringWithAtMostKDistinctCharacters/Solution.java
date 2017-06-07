public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	int hash[] = new int[256];
    	int len = s.length();
    	int result = 0, j = 0, count = 0;
    	for (int i = 0; i < len; i ++) {
    		while (j < len) {
				if (hash[(int) s.charAt(j)] > 0) {
					hash[(int) s.charAt(j ++)] ++;
				} else {
					if (count == k) {
						break;
					} else {
						hash[(int) s.charAt(j ++)] ++;
						count ++;
					}
				}
    		}
			result = Math.max(result, j - i);
    		hash[(int) s.charAt(i)] --;
    		if (hash[(int) s.charAt(i)] == 0) {
    			count --;
    		}
    	}
    	return result;
    }
}