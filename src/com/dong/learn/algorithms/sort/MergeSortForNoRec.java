package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/16.
 */
public class MergeSortForNoRec extends AlgotithmsTemplate{

    private Comparable[] copy;

    @Override
    public void sort(Comparable[] sourceArray) {
        int length = sourceArray.length;

        copy = new Comparable[length];

        for (int sz = 1; sz < length; sz *= 2){//sz 子数组的大小
            for(int lo = 0; lo < length - sz; lo += (sz * 2)){//lo 子数组索引
                merge(sourceArray, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
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

        MergeSortForNoRec mergeSort = new MergeSortForNoRec();

        System.out.println("before sort...");

        mergeSort.print(sourceArray);

        System.out.println("<===========>");

        mergeSort.sort(sourceArray);

        System.out.println("after sort...");

        mergeSort.print(sourceArray);
    }
}
