package com.dong.learn.algorithms.list;

/**
 * Created by coding-dong on 2017/10/16.
 */
public class JosephusCircle {

    private ListNode firstNode;

    private int circleNum;

    public void initList(){
        ListNode head = new ListNode();
        ListNode temp = head;
        for(int i = 1; i <= circleNum; i++){
            ListNode node = new ListNode();
            node.setItem(i);
            node.setNext(null);

            temp.setNext(node);

            temp = node;
        }

        temp.setNext(head.getNext());

        firstNode = temp.getNext();
    }

    public void printSeq(){
        int counter = 1;
        ListNode p = firstNode;
        ListNode pre = null;
        while (circleNum >= 3){
            if(counter % 3 == 0){
                //移除这个node
                pre.setNext(p.getNext());

                //恢复计数器
                counter = 1;

                System.out.print("node_" + p.getItem() + " -> ");
            }else {
                counter++;
                pre = p;
                p = p.getNext();
            }
        }

        if(circleNum > 0){
            ListNode temp = p;
            while (p.getNext() != temp){
                System.out.print("node_" + p.getItem());
                p = p.getNext();
            }
        }
    }

    public JosephusCircle(int circleNum) {
        this.circleNum = circleNum;
    }

    public static void main(String[] args){
        JosephusCircle josephusCircle = new JosephusCircle(41);
        josephusCircle.initList();
        josephusCircle.printSeq();
    }

    public void printN(){
//        JosephusCircle josephusCircle = new JosephusCircle(5);

    }
}
