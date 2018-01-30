package com.dong.learn.algorithms.list;

/**
 * Created by coding-dong on 2017/10/19.
 */
public class DouLinkedList<T extends Character> {

    private DualNode<T> head;

    public DouLinkedList(){
        head = new DualNode<>();
    }

    public void initLetterDLL(){
        DualNode<T> temp = head;
        for (int i = 0; i < 26; i++){
            DualNode<T> dualNode = new DualNode<>();
            Character data = (char) ('A' + i);
            dualNode.setData((T)data);

            dualNode.setPrior(temp);
            dualNode.setNext(temp.getNext());

            temp.setNext(dualNode);

            temp = dualNode;
        }

        temp.setNext(head.getNext());
        head.getNext().setPrior(temp);
    }

    public void printLetterSeq(int index){
        DualNode firstNode = head.getNext();

        if(index > 0){
            do {
                firstNode = firstNode.getNext();
            }while (--index > 0);
        }else if(index < 0){
            do {
                firstNode = firstNode.getPrior();
            }while (++index < 0);
        }
        DualNode cursor = firstNode;
        do {
            System.out.print(cursor.getData() + " ");
            cursor = cursor.getNext();
        }while (cursor != firstNode);

        System.out.println();
    }

    public static void main(String[] args){
        DouLinkedList<Character> douLinkedList = new DouLinkedList<>();
        douLinkedList.initLetterDLL();
        douLinkedList.printLetterSeq(-3);
        douLinkedList.printLetterSeq(3);
        douLinkedList.printLetterSeq(0);
    }
}
