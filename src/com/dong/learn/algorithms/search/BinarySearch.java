package com.dong.learn.algorithms.search;

import java.util.Arrays;

/**
 * Created by coding-dong on 2017/11/21.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] source = {110, 233, 163, 13, 4, 1, 94, 103, 101, 29, 87, 21, 18, 99, 32};

        Arrays.sort(source);

        System.out.println(Arrays.toString(source));
        System.out.println("<=======================>");

        int index = findItem(source, 233);

        System.out.println("index : " + index);
    }

    public static int findItem(int[] source, int item){
        int low = 0, high = source.length - 1;
        while (low <= high){
            int middle = (low + high) / 2;
            if(source[middle] == item){
                return middle;
            }else if(source[middle] > item){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
