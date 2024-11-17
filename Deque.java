class Deque {
    private class Node {
        int value;
        Node next;
        Node prev;
        
        Node(int value) {
            this.value = value;
        }
    }
    
    private Node head; 
    private Node tail; 

    public Deque() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1; 
        }
        int value = tail.value;
        if (head == tail) { 
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return value;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1; 
        }
        int value = head.value;
        if (head == tail) { 
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return value;
    }
}
