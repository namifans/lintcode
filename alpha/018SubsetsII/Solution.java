public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        findSubsets(nums, 0, result, current);
        return result;
    }

    private void findSubsets(int[] nums, int index, 
        List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<Integer>(current));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            findSubsets(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}