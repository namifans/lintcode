/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Set<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode n : current.neighbors) {
                if (!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }
        List<UndirectedGraphNode> nodes = new ArrayList<>(set);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
}