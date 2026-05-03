class MinStack {
    Node head;
    public MinStack() {
        head = new Node();
    }
    
    public void push(int val) {
        Node temp = head.next;
        int min = temp == null? val : Math.min(temp.min, val);
        Node insert = new Node(val, min);
        head.next = insert;
        insert.next = temp;
    }
    
    public void pop() {
        head.next = head.next.next;
    }
    
    public int top() {
        return head.next.value;
    }
    
    public int getMin() {
        return head.next.min;
    }

    class Node {
        int value;
        int min;
        Node next;
        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
        public Node() {
        }
    }
}
