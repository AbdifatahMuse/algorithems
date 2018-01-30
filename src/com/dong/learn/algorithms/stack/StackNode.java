package com.dong.learn.algorithms.stack;

/**
 * Created by coding-dong on 2017/10/21.
 */
public class StackNode<T> {
    private T data;

    private StackNode next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
