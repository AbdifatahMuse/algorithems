package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/11/4.
 */
public class BinaryInsertSort extends AlgotithmsTemplate{
    @Override
    public void sort(Comparable[] sourceArray) {
        for(int i = 0; i < sourceArray.length; i++){
            int low = 0, high = i - 1, insertPos = 0;
            Comparable temp = sourceArray[i];
            while (low <= high){
                int middle = (low + high) / 2;
                if(less(sourceArray[i], sourceArray[middle])){
                    high = middle - 1;
                }else if(!less(sourceArray[i], sourceArray[middle])){
                    low = middle + 1;
                }else {
                    insertPos = middle;
                    break;
                }
            }

            if (insertPos != 0){
                low = insertPos;
            }

            for(int m = i; m > low; m--){
                sourceArray[m] = sourceArray[m - 1];
            }


            sourceArray[low] = temp;
        }
    }

    public static void main(String[] args) {
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();

        Integer[] sourceArray = {67, 10, 35, 10, 79, 10, 2, 10, 62, 90, 100, 222, 3};

        System.out.println("before sort...");

        binaryInsertSort.print(sourceArray);

        System.out.println("<===========>");

        binaryInsertSort.sort(sourceArray);

        System.out.println("after sort...");

        binaryInsertSort.print(sourceArray);
    }
}
