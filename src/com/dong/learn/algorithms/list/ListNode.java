package com.dong.learn.algorithms.list;

/**
 * Created by coding-dong on 2017/10/16.
 */
public class ListNode {
    private int item;

    private ListNode next;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return item + "";
    }
}
