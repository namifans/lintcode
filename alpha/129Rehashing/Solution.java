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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0)
            return null;
        int newCap = hashTable.length * 2;
        ListNode[] result = new ListNode[newCap];
        for (int i = 0; i < hashTable.length; i++) {
            while(hashTable[i] != null) {
                ListNode node = hashTable[i];
                int hash = (node.val % newCap + newCap) % newCap;
                if (result[hash] == null) {
                    result[hash] = new ListNode(node.val);
                } else {
                    ListNode dummy = result[hash];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(node.val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return result;
    }
};
