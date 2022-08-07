package io.ghost.datastructure;

/**
 * Complexity will be O(1) for both enque and deque
 */
public class QueueImplementationCircularArray {

    int[] arr;

    int front;

    int rear;

    int capacity;

    public QueueImplementationCircularArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.front = -1;this.rear=1;
    }


    public int deque() {
        if (front == -1) {
            new Exception("Queue is empty");
        }
        int data = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return data;
    }

    // here we check the overflow condition by checking if (front+1)%capacity > (rear+1)%capacity
    public void enque(int data) {
        if ((front+1)%capacity == rear) {
            new Exception("OverFlow Exception! Queue is full");
            return;
        }
        // this is to check if Queue is empty
        if (front== -1) front=0;
        int index = (rear + 1) % capacity;
        rear = (rear + 1) % capacity;
        arr[index] = data;
    }
}
