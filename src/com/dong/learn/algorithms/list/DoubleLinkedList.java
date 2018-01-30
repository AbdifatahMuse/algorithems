package com.dong.learn.algorithms.list;

/**
 * Created by coding-dong on 2017/10/19.
 */
public class DoubleLinkedList<T> {
    private DualNode<T> head;

    private DualNode<T> tail;

    public void initList(){
        head = new DualNode<>();
        tail = new DualNode<>();

        tail.setNext(head);
    }

    public DoubleLinkedList(){
        initList();
    }

    public void insertNode(T data){
        DualNode<T> dualNode = new DualNode<>();
        dualNode.setData(data);

        DualNode firstNode = head.getNext();
        DualNode lastNode = tail.getPrior();

//        while (){
//
//        }
    }
}
