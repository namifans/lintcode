/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        ListNode current = node, start = node;
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        } else if (node.next == node) {
            node.next = newNode;
            newNode.next = node;
        } else {
            while((current.val > x || current.next.val <= x) 
                && current.next != start) {
                current = current.next;
            }
            ListNode next = current.next;
            newNode.next = next;
            current.next = newNode;
        }
        return newNode;
    }
}