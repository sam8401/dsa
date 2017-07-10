package com.sam8401.company;

/**
 * Created by suman on 08/07/17.
 */
public class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
