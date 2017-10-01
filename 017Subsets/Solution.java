public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // if (nums == null || nums.length == 0)
        //     return result;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, result, current);
        return result;
    }

    private void findSubsets(int[] nums, int index, 
        List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            findSubsets(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}