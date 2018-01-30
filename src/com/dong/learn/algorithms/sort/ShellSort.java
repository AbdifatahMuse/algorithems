package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/10.
 */
public class ShellSort extends AlgotithmsTemplate{

    @Override
    public void sort(Comparable[] sourceArray) {
        int h = 1;

        while(h < sourceArray.length / 3){
            h = 3 * h + 1;
        }

        while (h >= 1){

            for (int i = h; i < sourceArray.length; i++){
                for(int j = i; j >= h && less(sourceArray[j], sourceArray[j - h]); j -= h){
                    exchange(sourceArray, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 222, 3};

        ShellSort shellSort = new ShellSort();

        System.out.println("before sort...");

        shellSort.print(sourceArray);

        System.out.println("<===========>");

        shellSort.sort(sourceArray);

        System.out.println("after sort...");

        shellSort.print(sourceArray);
    }
}
