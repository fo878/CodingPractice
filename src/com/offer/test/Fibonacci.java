package com.offer.test;

import java.util.Arrays;

/*
* 0,1,2,3,4,5,6,7, 8, 9, 10
* 0,1,1,2,3,5,8,13,21,34,55..
* */
public class Fibonacci {
    /*
    * 1146ms
    * */
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    public int Fibonacci1(int n) {
        int[] a = new int[n+1];
        a[0] = 0;
        if (n==1) {
            a[1] = 1;
        }
        if (n<2){
            return a[n];
        }
        else {
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[n];
        }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.Fibonacci1(9));
        int[] ans1 = new int[20];
        int[] ans2 = new int[20];
        for (int i = 0; i < 20; i++) {
            int a = f.Fibonacci(i);
            ans1[i] = a;
        }
        for (int i = 0; i < 20; i++) {
            int a = f.Fibonacci1(i);
            ans2[i] = a;
        }
        System.out.println("ans1=" + Arrays.toString(ans1));
        System.out.println("ans2=" + Arrays.toString(ans2));
    }
}
