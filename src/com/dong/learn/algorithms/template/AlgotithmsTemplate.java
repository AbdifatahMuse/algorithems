package com.dong.learn.algorithms.template;

/**
 * Created by coding-dong on 2017/5/7.
 */
public abstract class AlgotithmsTemplate {

    /**
     * 排序算法
     * @param sourceArray
     */
    public abstract void sort(Comparable[] sourceArray);

    /**
     * 交换数据
     * @param sourceArray
     * @param i
     * @param j
     */
    public void exchange(Comparable[] sourceArray, int i, int j){
        if(sourceArray != null && i < sourceArray.length && j < sourceArray.length){
            Comparable temp = sourceArray[i];
            sourceArray[i] = sourceArray[j];
            sourceArray[j] = temp;
        }
    }

    /**
     * 打印数组
     * @param sourceArray
     */
    public void print(Comparable[] sourceArray){
        if(sourceArray != null){
            for(Comparable obj : sourceArray){
                System.out.print(obj.toString() + " ");
            }

            System.out.println();
        }
    }

    /**
     * 比较数据
     * @param a
     * @param b
     * @return
     */
    public boolean less(Comparable a, Comparable b){
        return a.compareTo(b) == -1;
    }
}
