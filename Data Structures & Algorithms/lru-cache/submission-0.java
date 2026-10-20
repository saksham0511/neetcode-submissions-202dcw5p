class LRUCache {
    int capacity;
    Node head;
    Node tail;
    int count;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new Node();
        this.tail = new Node();
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            removeNode(node);
            addNode(node);
        }
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        removeNode(node);
        node = new Node();
        node.key = key;
        node.value = value;
        addNode(node);
        if (count > capacity) {
            removeNode(head.next);
        }
    }

    private void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        count += 1;
        cache.put(node.key, node);
    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        }
        cache.put(node.key, null);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        count -= 1;
    }

    class Node {
        Node next;
        Node prev;
        int key;
        int value;
        public Node() {

        }
    }
}
