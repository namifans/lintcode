public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int z = 0, nz = 0;
        while (z < nums.length && nz < nums.length) {
            while(z < nums.length && nums[z] != 0) {
                z++;
            }
            while(nz < nums.length && nums[nz] == 0) {
                nz++;
            }
            if (nz < nums.length && z < nums.length && z < nz) {
                swap(nums, z, nz);
                z++;
            } 
            nz++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}