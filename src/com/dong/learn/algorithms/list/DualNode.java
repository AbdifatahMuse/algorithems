package com.dong.learn.algorithms.list;

/**
 * Created by coding-dong on 2017/10/19.
 */
public class DualNode<T> {

    private T data;

    private DualNode prior;

    private DualNode next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DualNode getPrior() {
        return prior;
    }

    public void setPrior(DualNode prior) {
        this.prior = prior;
    }

    public DualNode getNext() {
        return next;
    }

    public void setNext(DualNode next) {
        this.next = next;
    }
}
