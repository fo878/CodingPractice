package com.wrong.dongfang2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        String[] strings = line.trim().split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
    }

    public static int maxProfit(int k,int[] prices){
        return 0;
    }
}
