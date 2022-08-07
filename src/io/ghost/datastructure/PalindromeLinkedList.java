package io.ghost.datastructure;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode("A");
        list.addNode("B");
        list.addNode("C");
        list.addNode("D");
        list.addNode("C");
        list.addNode("B");
        list.addNode("A");
        System.out.println(list.head);
        Node midNode = midNode(list.head);
        Node reverseMid = reverse(midNode.next);
        boolean isPalindrome = true;
        while(reverseMid.next != null) {
            if(reverseMid.data != list.head.data) {
                isPalindrome = false;
                break;
            }
            reverseMid = reverseMid.next;
            list.head = list.head.next;
        }
        System.out.println("LinkedList is palindrome: " +isPalindrome);
    }

    public static Node midNode(Node head) {
        Node fast = head;
        Node slow = head;
        Node mid = null;
        while(fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            mid = slow;
        }
        return mid;
    }

    // A--->B---> C---> D---> C---> B---> A---><NULL>
    public static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        while(current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
