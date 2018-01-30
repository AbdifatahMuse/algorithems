package com.dong.learn.algorithms.stack;

/**
 * Created by coding-dong on 2017/10/21.
 */
public class LinkedStack<T> {

    private StackNode<T> top;

    private int stackSize = 0;

    public LinkedStack(){
        top = new StackNode();
    }

    public T pop(){
        if(stackSize == 0){
            return null;
        }

        StackNode<T> node = top.getNext();

        top.setNext(node.getNext());

        node.setNext(null);

        stackSize--;

        return node.getData();
    }

    public void push(T data){
        StackNode<T> stackNode = new StackNode<>();
        stackNode.setData(data);

        stackNode.setNext(top.getNext());
        top.setNext(stackNode);

        stackSize++;
    }

    public void clear(){
        StackNode temp = top;
        StackNode next = null;
        do{
            next = temp.getNext();
            temp.setNext(null);
            temp = next;
        } while (--stackSize > 0);
    }

    public T peek(){
        if(stackSize == 0){
            return null;
        }

        return (T)top.getNext().getData();
    }

    public int size(){
        return stackSize;
    }
}
