public class Solution {
    /*
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        int count[] = new int[k];
        for (int i = 0; i < colors.length; i++) {
            count[colors[i] - 1]++;
        }
        int current = 0;
        for (int i = 0; i < k; i++) {
            while (count[i]-- > 0) {
                colors[current++] = i + 1;
            }
        }
    }
}