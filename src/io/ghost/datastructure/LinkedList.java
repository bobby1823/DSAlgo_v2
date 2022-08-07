package io.ghost.datastructure;

public class LinkedList {
     Node head = null;
    Node tail = null;
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode("foo");
        list.addNode("bar");
        list.addNode("jack");
        list.addNode("sam");
        list.insertAtIndex(3, "duck");
        // Printing LinkedList
        list.printLinkedList();
    }

    public void addNode(String data) {
        Node<String> newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prependNode(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("Printing completed!");
    }
    // foo--->bar----->jack---->sam
    public void insertAtIndex(int index, String data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        Node prevNode = head;
        if (index == 0) {
            prependNode(data);
            return;
        }
        while(true) {
            if (index == 0) {
                prevNode.next = newNode;
                newNode.next = currentNode;
                return;
            }
            index--;
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    // foo--->bar----->jack---->sam--->ron---> <NULL>
    public Node reverse(Node node) {
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    // foo--->bar----->jack---->sam--->ron---> <NULL>
    public Node reverseRecursion(Node head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node nextHead = head.next;
        nextHead.next = head;
        head.next = null;
        return newHead;
    }
}
