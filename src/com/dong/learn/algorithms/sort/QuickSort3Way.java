package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/21.
 */
public class QuickSort3Way extends AlgotithmsTemplate{

    @Override
    public void sort(Comparable[] sourceArray) {
        quickSort3Way(sourceArray, 0, sourceArray.length - 1);
    }

    private void quickSort3Way(Comparable[] sourceArray, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo, gt = hi, i = lo + 1;
        Comparable middleValue = sourceArray[lo];

        while (i <= gt){
            int cmp = sourceArray[i].compareTo(middleValue);

            if(cmp < 0){
                exchange(sourceArray, lt++, i++);
            }else if (cmp > 0){
                exchange(sourceArray, i, gt--);
            }else {
                i++;
            }
        }

        quickSort3Way(sourceArray, lo, lt - 1);
        quickSort3Way(sourceArray, gt + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 35, 222, 3};

        QuickSort3Way quickSort3Way = new QuickSort3Way();

        System.out.println("before sort...");

        quickSort3Way.print(sourceArray);

        System.out.println("<===========>");

        quickSort3Way.sort(sourceArray);

        System.out.println("after sort...");

        quickSort3Way.print(sourceArray);
    }
}
