public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int s[]) {
        Arrays.sort(s);
        int len = s.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
        	int l = 0;
        	int r = i - 1;
	        while (l < r) {
	        	if (s[l] + s[r] > s[i]) {
	        		count += r - l;
	        		r--;
	        	} else 
	        		l++;
	        }
		}
		return count;
    }
}
