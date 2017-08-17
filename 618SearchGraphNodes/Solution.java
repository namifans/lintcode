/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<Integer> searchedSet = new HashSet<>();
        queue.add(node);
        searchedSet.add(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            if (values.get(current) == target)
                return current;
            for (UndirectedGraphNode no : current.neighbors) {
                if (!searchedSet.contains(no.label)) {
                    queue.add(no);
                    searchedSet.add(no.label);
                }
            }
        }
        return null;
    }
}