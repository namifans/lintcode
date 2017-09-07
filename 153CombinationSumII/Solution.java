public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0)
            return result;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(num);
        findCombination(num, target, 0, result, current);
        return result;
    }

    private void findCombination(int[] num, int target, int index,
        List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (num[i] > target)
                break;
            if (i != index && num[i] == num[i - 1])
                continue;
            current.add(num[i]);
            findCombination(num, target - num[i], i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}