package io.ghost.datastructure;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack s1;
    Stack s2;

    public ImplementQueueUsingStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    // Here we will have choosen s1 to contain all the elements for push operation
    public void push(int data) {
        s1.push(data);
    }

    public int pop() throws Exception {
        if (s1.empty()) {
            throw new Exception("Queue is empty");
        }
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        int data = (Integer) s2.pop();
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
        return data;
    }

    public int peek() throws Exception {
        if (s1.empty()) {
            throw new Exception("Queue is empty");
        }
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        int data = (Integer) s2.peek();
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
        return data;
    }
}
