package com.offer.test;

import java.util.ArrayList;

public class RotateArrayMinNumber {
    public int minNumberInRotateArray(int [] array) {
        int min = array[0];
        for (int i : array) {
            if (i<min){
                min = i;
            }
        }
        return min;
    }
}
