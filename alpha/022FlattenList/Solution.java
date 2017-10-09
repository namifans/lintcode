/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        if (nestedList == null || nestedList.isEmpty())
            return result;
        if (nestedList.get(0).isInteger()) {
            result.add(nestedList.get(0).getInteger());
            return result;
        } 
        Deque<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n : nestedList.get(0).getList()) {
            queue.addLast(n);
        }
        while (!queue.isEmpty()) {
            NestedInteger current = queue.pollFirst();
            if (current.isInteger())
                result.add(current.getInteger());
            if (current.getList() != null) {
                for (int i = current.getList().size() - 1; i >= 0; i--) {
                    queue.addFirst(current.getList().get(i));
                }
            }
        }
        return result;
    }
}