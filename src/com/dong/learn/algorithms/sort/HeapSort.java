package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/6/6.
 */
public class HeapSort extends AlgotithmsTemplate{

    @Override
    public void sort(Comparable[] sourceArray) {
        heapSort(sourceArray, sourceArray.length - 1);
    }

    private void heapSort(Comparable[] sourceArray, int length) {
        //构造堆
        for (int k = length / 2; k >= 1; k--){
            sink(sourceArray, k, length);
        }

        while (length > 1){
            exchange(sourceArray, 1, length--);
            sink(sourceArray, 1, length);
        }
    }

    private void sink(Comparable[] sourceArray, int i, int length) {
        int k = i;

        while (2 * i <= length){
            k = 2 * i;
            if(k < length && less(sourceArray[k], sourceArray[k + 1])){
                k++;
            }

            if(less(sourceArray[k], sourceArray[i])){
                break;
            }

            exchange(sourceArray, k, i);

            i = k;
        }
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {0, 67, 35, 79, 10, 2, 62, 90, 100, 222, 3};

        HeapSort heapSort = new HeapSort();

        System.out.println("before sort...");

        heapSort.print(sourceArray);

        System.out.println("<===========>");

        heapSort.sort(sourceArray);

        System.out.println("after sort...");

        heapSort.print(sourceArray);
    }
}
