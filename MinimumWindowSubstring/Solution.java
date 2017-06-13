public class Solution {
	private int[] initHash(int[] hash, String target) {
		for (int i = 0; i < target.length(); i++) {
			hash[(int) target.charAt(i)]++;
		}
		return hash;
	}
	private boolean isValid(int[] sourceHash, int[] targetHash) {
		for (int i = 0; i < 256; i++) {
			if (targetHash[i] > sourceHash[i])
				return false; 
		}
		return true;
	}
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
    	String result = "";
    	int[] targetHash = new int[256];
    	int[] sourceHash = new int[256];
    	initHash(targetHash, target);
    	int count = Integer.MAX_VALUE, j = 0, len = source.length();
    	for (int i = 0; i < len; i++) {
    		while (!isValid(sourceHash, targetHash) && j < len) {
 				sourceHash[(int) source.charAt(j)]++;
				if (j < len)
					j++;
				else
					break;
    		}
			if (isValid(sourceHash, targetHash) && count > j - i) {
				count = Math.min(count, j - i);
				result = source.substring(i, j);
			}
    		sourceHash[(int) source.charAt(i)]--;
    	}
    	return result;
    }
}