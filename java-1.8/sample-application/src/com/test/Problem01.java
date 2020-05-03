package com.test;

public class Problem01 {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(8);
        linkedList.insertAtEnd(9);

        assert linkedList.getSize() == 9 : "Items got missed";

        System.out.println("Original Linked List");
        linkedList.print();

        int chunkSize = 6;
        linkedList.selectiveReverse(chunkSize);

        assert linkedList.getSize() == 9 : "Items got lost";

        System.out.println();
        System.out.println("Linked List after selective reversal with chunk size " + chunkSize);
        linkedList.print();
    }
}
