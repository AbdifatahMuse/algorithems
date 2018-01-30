package com.dong.learn.algorithms.sort;

import com.dong.learn.algorithms.template.AlgotithmsTemplate;

/**
 * Created by coding-dong on 2017/5/7.
 */
public class InsertSort extends AlgotithmsTemplate{
    @Override
    public void sort(Comparable[] sourceArray) {
        Comparable[] result = new Comparable[sourceArray.length];

        for (int i = 0; i < sourceArray.length; i++){
            //插入位置
            int insertPosition = i;

            for (int j = 0; j < i; j++){
                if(less(sourceArray[i], result[j])){
                    //记录插入位置
                    insertPosition = j;
                    break;
                }
            }

            //右移
            for(int m = i; m > insertPosition; m--){
//                exchange(result, m,m - 1);
                result[m] = result[m - 1];
            }

            result[insertPosition] = sourceArray[i];

        }

        System.arraycopy(result, 0, sourceArray, 0, result.length);
    }

    public static void main(String[] args) {
        Integer[] sourceArray = {67, 35, 79, 10, 2, 62, 90, 100, 222, 3};

        InsertSort insertSort = new InsertSort();

        System.out.println("before sort...");

        insertSort.print(sourceArray);

        System.out.println("<===========>");

        insertSort.sort(sourceArray);

        System.out.println("after sort...");

        insertSort.print(sourceArray);
    }
}
