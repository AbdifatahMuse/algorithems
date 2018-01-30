package com.dong.learn.algorithms.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by coding-dong on 2017/6/4.
 */
public class MaxPQ<T extends Comparable<T>> {

    private T[] maxPQ;

    private int length;

    public MaxPQ(int size){
        maxPQ = (T[])new Comparable[size + 1];
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void insert(T item){
        maxPQ[++length] = item;

        //上浮
        swim(length);
    }

    private void swim(int length) {
        int k = length;
        while (k > 1 && !less(k, k / 2)){
            exch(k, k / 2);

            k = k / 2;
        }
    }

    private boolean less(int k, int i) {
        return maxPQ[k].compareTo(maxPQ[i]) < 0;
    }

    public T delMax(){
        T max = maxPQ[1];

        exch(length, 1);

        maxPQ[length--] = null;

        sink(1);

        return max;
    }

    private void sink(int i) {
        int k = i;

        while (2 * i <= length){
            k = 2 *  i;
            if(k < length && less(k, k + 1)){
                k++;
            }

            if(less(k, i)){
                break;
            }

            exch(k, i);

            i = k;
        }
    }

    private void exch(int length, int i) {
        T temp = maxPQ[length];
        maxPQ[length] = maxPQ[i];
        maxPQ[i] = temp;
    }

    public static void main(String[] args) {
        int size = 10;

        MaxPQ<Integer> maxPQ = new MaxPQ<>(size);

        Random random = new Random();

        for(int i = 0; i < size; i++){
            maxPQ.insert(random.nextInt(100));
        }

        System.out.println("<=======================>");
        System.out.println(Arrays.toString(maxPQ.maxPQ));

        for (int i = 0; i < size / 2; i++){
            System.out.print(maxPQ.delMax() + " ");
        }

        System.out.println("/n <=====================>");
        System.out.println(Arrays.toString(maxPQ.maxPQ));
    }
}
