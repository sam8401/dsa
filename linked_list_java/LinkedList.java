package com.sam8401.company;

/**
 * Created by suman on 08/07/17.
 */
public class LinkedList {

    public Node init() {
        Node head = new Node(0);
        return head;
    }

    public void add (Node head, int value) {
        if(head.getValue() == 0) { // adding first element
            head.setValue((value));
            return;
        }

        else if(head.getNext() == null) {
            head.setNext(new Node(value));
        }

        else {
            add(head.getNext(), value);
        }
    }

    public void print(Node head) {
        Node first = head ;

        while(first != null) {

            System.out.print(first.getValue() + "-> ");
            first = first.getNext();

        }

        System.out.println("null");
    }


    public void reverseHelper(Node head, Node parent, Node newHead) {
        if(head.getNext() == null) {
            head.setNext(parent);
            newHead.setValue(head.getValue());
            newHead.setNext(parent);
            return;
        }

        Node neighbour = head.getNext();
        reverseHelper(neighbour, head, newHead);
        neighbour.setNext(head);
        head.setNext(null);
    }

    public Node reverse(Node head) {
        Node newHead = new Node(0);
        reverseHelper(head, null, newHead);

        return newHead;
    }
}
