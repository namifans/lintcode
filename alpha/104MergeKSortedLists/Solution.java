/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.isEmpty())
            return null;
        ListNode head = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), 
            new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            ListNode current = lists.get(i);
            while(current != null) {
                queue.offer(current);
                current = current.next;
            }
        }
        int size = queue.size();
        ListNode current = head;
        while (size-- >= 0) {
            current.next = queue.poll();
            current = current.next;
        }
        return head.next;
    }
}
