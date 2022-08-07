package io.ghost.datastructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInJava {

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue1.offer(1);

        queue2.peek();
    }
}
