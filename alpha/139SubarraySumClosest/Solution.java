class Pair {
    int sum;
    int index;
    public Pair(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result[0] = result[1] = 0;
            return result;
        }
        Pair[] preSum = new Pair[nums.length + 1];
        preSum[0] = new Pair(0, 0);
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = new Pair(sum + nums[i-1], i);
            sum = preSum[i].sum;
        }
        Arrays.sort(preSum, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(preSum[i].sum - preSum[i - 1].sum) < min) {
                min = Math.abs(preSum[i].sum - preSum[i - 1].sum);
                int[] temp = new int[2];
                temp[0] = preSum[i].index - 1;
                temp[1] = preSum[i - 1].index - 1;
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];      
            }
        }
        return result;
    }
}
