package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/7.
 */
public class SelectionSort extends AlgotithmsTemplate{

    @Override
    public void sort(Comparable[] sourceArray) {
        for(int i = 0; i < sourceArray.length; i++){
            //最小值
            Comparable minValue = sourceArray[i];

            //最小值下表
            int position = i;

            for(int j = i; j < sourceArray.length; j++){
                if(less(sourceArray[j], minValue)){
                    position = j;
                    minValue = sourceArray[j];
                }
            }

            exchange(sourceArray, i, position);
        }
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 222, 3};

        SelectionSort selectionSort = new SelectionSort();

        System.out.println("before sort...");

        selectionSort.print(sourceArray);

        System.out.println("<===========>");

        selectionSort.sort(sourceArray);

        System.out.println("after sort...");

        selectionSort.print(sourceArray);
    }
}
