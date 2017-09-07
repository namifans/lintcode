public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
         List<Integer> current = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(current);
            return result;
        }
        findPermute(nums, result, current);
        return result;
    }

    private void findPermute(int[] nums,
        List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i]))
                continue;
            current.add(nums[i]);
            findPermute(nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}