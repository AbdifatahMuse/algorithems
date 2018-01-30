package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/21.
 */
public class QuickSort extends AlgotithmsTemplate{

    @Override
    public void sort(Comparable[] sourceArray) {
        quickSort(sourceArray, 0, sourceArray.length - 1);
    }

    private void quickSort(Comparable[] sourceArray, int lo, int hi) {
        if (lo >= hi) return;

        int position = position(sourceArray, lo, hi);

        quickSort(sourceArray, lo, position - 1);

        quickSort(sourceArray, position + 1, hi);
    }

    private int position(Comparable[] sourceArray, int lo, int hi) {
        int i = lo, j = hi + 1;

        Comparable middleValue = sourceArray[lo];

        while (true){
            while(less(sourceArray[++i], middleValue)){
                if(i == hi){
                    break;
                }
            }

            while (less(middleValue, sourceArray[--j])){
                if(j == lo){
                    break;
                }
            }

            if(i >= j){
                break;
            }

            exchange(sourceArray, i, j);
        }

        exchange(sourceArray, lo, j);

        return j;
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 35, 222, 3};

        QuickSort quickSort = new QuickSort();

        System.out.println("before sort...");

        quickSort.print(sourceArray);

        System.out.println("<===========>");

        quickSort.sort(sourceArray);

        System.out.println("after sort...");

        quickSort.print(sourceArray);
    }



}
