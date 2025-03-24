class MyLinkedList {
    Node head;
    int size;
    
    public static class Node {  // Make Node class static
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if (index >= size)
            return -1;
        int count = 0;
        Node current = head;
        while (count < index) {
            count++;
            current = current.next;
        }
        return current.value;
    }
    
    public void addAtHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int value) {
        if (head == null) {
            addAtHead(value);
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            Node newNode = new Node(value);
            current.next = newNode;
            size++;
        }
    }
    
    public void addAtIndex(int index, int value) {
        if (index > size)
            return;
        if (index == 0) {
            addAtHead(value);
        } else {
            int count = 1;
            Node current = head;
            while (count < index) {
                current = current.next;
                count++;
            }
            Node newNode = new Node(value);
            Node nextNode = current.next;
            current.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        if (index == 0) {
            head = head.next;
            size--;
        } else {
            int count = 1;
            Node current = head;
            while (count < index) {
                count++;
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }
}
