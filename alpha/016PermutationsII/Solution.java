public class Solution {
    /*
     * @param nums:  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(current);
            return result;
        }
        boolean[] visitSet = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visitSet[i] = false;
        }
        Arrays.sort(nums);
        findPermute(nums, visitSet, result, current);
        return result;
    }

    private void findPermute(int[] nums, boolean[] visitSet, 
        List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visitSet[i] || (i != 0 && nums[i] == nums[i - 1] 
                && !visitSet[i - 1]))
                continue;
            visitSet[i] = true;
            current.add(nums[i]);
            findPermute(nums, visitSet, result, current);
            current.remove(current.size() - 1);
            visitSet[i] = false;
        }
    }
}