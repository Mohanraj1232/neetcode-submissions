class LRUCache {

    HashMap<Integer, ListNode> map;
    ListNode root;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        root = null;
        tail = null;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        if (node != tail) {
            remove(node);
            addLast(node);
        }

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            ListNode node = map.get(key);

            node.val = value;

            if (node != tail) {
                remove(node);
                addLast(node);
            }

            return;
        }

        ListNode node = new ListNode(key, value);

        map.put(key, node);
        addLast(node);

        if (map.size() > capacity) {

            map.remove(root.key);

            remove(root);
        }
    }

    private void addLast(ListNode node) {

        if (tail == null) {
            root = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;

        tail = node;
    }

    private void remove(ListNode node) {

        if (node == root) {
            root = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;

        if (root == null) {
            tail = null;
        }
    }
}

class ListNode {

    int key;
    int val;

    ListNode prev;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}