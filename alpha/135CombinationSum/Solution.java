public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        findCombination(result, current, target, candidates, 0);
        return result;
    }

    public void findCombination(List<List<Integer>> result, List<Integer> current, 
        int target, int[] candidates, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            if (i != index && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            findCombination(result, current, target - candidates[i], candidates, i);
            current.remove(current.size() - 1);
        }
    }
}