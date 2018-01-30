package com.dong.learn.algorithms.arrange;

/**
 * Created by coding-dong on 2017/5/21.
 */
public class Arrange {

    public <T> void arrange(T[] source, int start){
        if(start == source.length){
            printRange(source);
            return;
        }

        for (int i = start; i < source.length; i++){
            swap(source, start, i);
            arrange(source, start + 1);
            swap(source, start, i);
        }
    }

    private <T> void swap(T[] source, int start, int i) {
        T temp = source[start];
        source[start] = source[i];
        source[i] = temp;
    }

    private <T> void printRange(T[] source) {
        for (T t : source){
            System.out.print(t.toString() + " ");
        }
        System.out.print("\n<====================>\n");
//        System.out.println("<====================>");
    }

    public static void main(String[] args) {
        String[] source = {"a", "b", "c", "d"};

        Arrange arrange = new Arrange();
        arrange.arrange(source, 0);
    }
}
