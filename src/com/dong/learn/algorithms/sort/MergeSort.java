package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/15.
 */
public class MergeSort extends AlgotithmsTemplate{

    private Comparable[] copy = null;

    @Override
    public void sort(Comparable[] sourceArray) {
        copy = new Comparable[sourceArray.length];

        innerSort(sourceArray, 0, sourceArray.length - 1);
    }

    private void innerSort(Comparable[] sourceArray, int lo, int hi) {
        if (lo >= hi){
            return;
        }

        int mid = (lo + hi) / 2;

        innerSort(sourceArray, lo, mid);

        innerSort(sourceArray, mid + 1, hi);

        merge(sourceArray, lo, mid, hi);
    }

    private void merge(Comparable[] sourceArray, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        //先赋值
        for(int k = lo; k <= hi; k++){
            copy[k] = sourceArray[k];
        }

        for (int k = lo; k <= hi; k++){
            if(i > mid){
                sourceArray[k] = copy[j++];
            }else if(j > hi){
                sourceArray[k] = copy[i++];
            }else if (less(copy[i], copy[j])){
                sourceArray[k] = copy[i++];
            }else {
                sourceArray[k] = copy[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 222, 3};

        MergeSort mergeSort = new MergeSort();

        System.out.println("before sort...");

        mergeSort.print(sourceArray);

        System.out.println("<===========>");

        mergeSort.sort(sourceArray);

        System.out.println("after sort...");

        mergeSort.print(sourceArray);
    }
}
