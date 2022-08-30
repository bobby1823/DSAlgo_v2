package io.ghost.datastructure;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
// 3 pointer problem
public class ReverseLinkedList {

    Node head = null;
    Node tail = null;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.addNode(8);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        System.out.println(list.head);
//        Node reversedNode = list.reverseBetween(list.head, 3, 4);
        Node reversedNode = list.reverse(list.head);
        System.out.println(reversedNode);
    }


    public static Node reverse(Node head) {
        if (head == null)
            return null;
        Node newList = head;
        int size = 0;
        Node prev = null;
        Node curr = head;

        while(newList != null) {
            Node tempNext = newList.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;

            newList = tempNext;
        }

        return prev;
    }
    // 8--->1-->2--->3-----4--->5----6---> <NULL>
    public Node reverseBetween(Node head, int left, int right) {
        Node currentNode = head;
        Node prev = null;
        Node leftPrev = null;
        Node rightNode = null;
        int count = 0;
        // Finding the leftNode and Right Node
        for (int i = 0; i < left-1; i++) {
            leftPrev = currentNode;
            leftPrev.next =
            currentNode = currentNode.next;
        }

        // reverse left to right
        for (int i = 0; i < right-left+1; i++) {
            Node temp = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = temp;
        }
        leftPrev.next.next = currentNode;
        leftPrev.next = prev;
        return leftPrev;
    }





    // This returns then index of any given number in list
    public static int readList(Node head, int number) {
        Node currentNode = head;
        int index = -1;
        int count = 0;
        while (currentNode != null) {
            if ((Integer) currentNode.data == number) {
                return count;
            }
            currentNode = currentNode.next;
            count++;
        }
        return index;
    }

    public void addNode(int data) {
        Node<Integer> newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
