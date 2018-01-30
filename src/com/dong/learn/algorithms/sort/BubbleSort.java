package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/11/4.
 */
public class BubbleSort extends AlgotithmsTemplate {

    @Override
    public void sort(Comparable[] sourceArray) {
        for(int i = 0; i < sourceArray.length; i++){
            for (int j = i; j < sourceArray.length; j++){
                if(!less(sourceArray[i], sourceArray[j])){
                    exchange(sourceArray, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {0, 67, 35, 79, 10, 2, 62, 90, 100, 222, 3};
        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("before sort...");

        bubbleSort.print(sourceArray);

        System.out.println("<===========>");

        bubbleSort.sort(sourceArray);

        System.out.println("after sort...");

        bubbleSort.print(sourceArray);
    }
}
