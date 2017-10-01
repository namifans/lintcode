class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int count = 1;
        while (count < n) {
            int min = min(uglyNum[idx2] * 2, 
                uglyNum[idx3] * 3,
                uglyNum[idx5] * 5);
            if (min == uglyNum[idx2] * 2) {
                idx2++;
            }
            if (min == uglyNum[idx3] * 3) {
                idx3++;
            }
            if (min == uglyNum[idx5] * 5) {
                idx5++;
            }
            uglyNum[count] = min;
            count++;
        }
        return uglyNum[n - 1];
    }

    private int min(int a, int b, int c) {
        int min = a > b ? b : a;
        min = min > c ? c : min;
        return min; 
    }
}
