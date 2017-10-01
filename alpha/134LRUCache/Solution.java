public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap = 0;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToTail(node);
            return map.get(key).value;
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) == -1) {
            if (map.size() >= cap) {
                removeHead();
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToTail(newNode);
        } else {
            map.get(key).value = value;
        }
    }

    private void moveToTail(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void removeHead() {
        map.remove(head.next.key);
        head.next.next.prev = head;
        head.next = head.next.next;
    }
}