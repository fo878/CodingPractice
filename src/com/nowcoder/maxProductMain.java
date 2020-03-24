package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 有n个学生站成一排，每个学生有一个能力值，牛牛想从这n个学生中按照顺序选取k名学生，
* 要求相邻两个学生的位置编号的差不超过d，使得这k个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * */
public class maxProductMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        String thirdLine = br.readLine();
        String[] strings1 = secondLine.trim().split(" ");
        int n = Integer.parseInt(firstLine);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strings1[i]);
        }
        String[] strings2 = thirdLine.trim().split(" ");
        int k = Integer.parseInt(strings2[0]);
        int d = Integer.parseInt(strings2[1]);
        maxProductMain foo = new maxProductMain();
        System.out.println(foo.maxProduct(n,array,k,d));
    }
    long maxProduct(int n,int[] array,int k,int d) {
        long[][] max = new long[k][n];
        long[][] min = new long[k][n];
        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++) {
                max[i][j] = 1;
                if (i == 0) {
                    min[i][j] = array[j];
                    max[i][j] = array[j];
                }
            }

        for (int i = 1; i < k; i++)
            for (int j = 0; j < n; j++)
                for (int m = 1; m <= d; m++) {
                    if (j - m >= 0) {
                        if (array[j] > 0) {
                            min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * array[j]);
                            max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * array[j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * array[j]);
                            max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * array[j]);
                        }
                    }
                }
        long Max = 0;
        for (int i = 0; i < n; i++)
            Max = Math.max(Max, max[k - 1][i]);
        return Max;
    }
}
