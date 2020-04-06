package com.nowcoder.divid3;

import java.io.IOException;
import java.util.Scanner;
/*
* 1 12 123 1234 12345
* 1 3  6   10   15
* */
public class Main{
    public static void main(String[] arg) throws IOException{
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int n = end;
        int[] arraySum = new int[n];
        arraySum[0] = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            arraySum[i] = arraySum[i-1] + i+1;
        }
        for (int i = 0; i < n; i++) {
            if (arraySum[i]%3==0 && i>=start-1 && i<=end-1){
                count++;
            }
        }
        System.out.println(count);
    }
}