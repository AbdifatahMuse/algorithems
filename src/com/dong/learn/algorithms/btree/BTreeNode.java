package com.dong.learn.algorithms.btree;

/**
 * Created by coding-dong on 2017/10/24.
 */
public class BTreeNode<T extends String> {

    private T data;

    private BTreeNode lChild;

    private BTreeNode rChild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTreeNode getlChild() {
        return lChild;
    }

    public void setlChild(BTreeNode lChild) {
        this.lChild = lChild;
    }

    public BTreeNode getrChild() {
        return rChild;
    }

    public void setrChild(BTreeNode rChild) {
        this.rChild = rChild;
    }
}
