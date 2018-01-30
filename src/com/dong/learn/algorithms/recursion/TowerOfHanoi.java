package com.dong.learn.algorithms.recursion;

/**
 * Created by coding-dong on 2017/10/22.
 */
public class TowerOfHanoi {
    public static final String PILLAR_X = "X";
    public static final String PILLAR_Y = "Y";
    public static final String PILLAR_Z = "Z";

    public static final String LINK_STR = "-------->";

    public void move(int num, String x, String y, String z){
        if(num == 1){
            System.out.println(x + LINK_STR + z);
        }else {
            move(num - 1, x, z, y);
            System.out.println(x + LINK_STR + z);
            move(num - 1, y, x, z);
        }
    }

    public static void main(String[] args){
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move(4, PILLAR_X, PILLAR_Y, PILLAR_Z);
    }
}
