/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {

    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<RandomListNode, RandomListNode> pair = (Map.Entry) it.next(); 
            RandomListNode orgNode = pair.getKey();
            RandomListNode newNode = pair.getValue();
            newNode.next = map.get(orgNode.next);
            newNode.random = map.get(orgNode.random);
        }
        return map.get(head);
    }
}