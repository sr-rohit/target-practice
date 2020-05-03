package com.test;

import java.util.List;

public class LinkedList {

    private ListItem start;
    private ListItem end;
    private int size;

    public LinkedList() {

        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void print() {

        ListItem temp = this.start;
        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void insertAtEnd(int data) {

        ListItem newItem = new ListItem(data, null);
        this.size++;

        if (this.start == null && this.end == null) {

            this.start = newItem;
            this.end = newItem;

        } else {

            this.end.setNext(newItem);
            this.end = newItem;
        }
    }

    public void selectiveReverse(int chunk) {

        if (chunk <= 1) {
            return;
        }

        ListItem startItem = this.start, endItem, lastEndItem = null, nextItem;
        int subChunk;

        while(true) {

            subChunk = 1;
            endItem = startItem;
            while (subChunk < chunk && endItem.getNext() != null) {

                endItem = endItem.getNext();
                subChunk++;
            }

            nextItem = endItem.getNext();
            reverse(startItem, endItem);

            if (lastEndItem == null) {
                this.start = endItem;
            } else {
                lastEndItem.setNext(endItem);
            }

            startItem.setNext(nextItem);
            lastEndItem = startItem;
            startItem = nextItem;

            if (startItem == null) {
                break;
            }
        }
    }

    private void reverse(ListItem startItem, ListItem endItem) {

        if (startItem == endItem) {
            return;
        }

        ListItem first = startItem, second = startItem.getNext(), third;

        while (first != endItem) {

            third = second.getNext();
            second.setNext(first);

            first = second;
            second = third;
        }
    }
}

class ListItem {

    private int data;
    private ListItem next;

    public ListItem(int data, ListItem next) {

        this.setData(data);
        this.setNext(next);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
