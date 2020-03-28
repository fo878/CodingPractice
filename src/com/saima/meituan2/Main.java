package com.saima.meituan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 有这么一个奇怪的符号：在一张正方形的纸上，有许多不同半径的圆。
* 他们的圆心都在正方形的重心上（正方形的重心位于正方形两条对角线的交叉点上）。
* 最大的圆的外面部分是白色的。最外层的圆环被涂成了黑色，
* 接下来第二大的圆环被涂层白色，
* 接下来第三大的圆环被涂层黑色。以此类推，例如下图。
* 现在，给你这些圆的半径，请问黑色部分的面积是多少？精确到小数点后5位输出（四舍五入）。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine().trim();
        int n = Integer.parseInt(line1);//圆环的个数
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        double res = calculate(num,n);
//        String result = String.format("%.5f",res);
        String result = String.format("%.5f",res);
        res = Math.round(res*100000)*0.00001d;
        System.out.println(res);
    }

    private static double calculate(int[] num,int n){
        double ans = 0.0;
        if (n==0){
            return 0.0;
        }
        if (n==1){
            return Math.PI*num[0]*num[0];
        }
        boolean flag = true;
        int i = n-1;
        while (i>=0){
            if (flag){
                ans += Math.PI*num[i]*num[i];
                i--;
                flag = false;
            }else {
                ans -= Math.PI*num[i]*num[i];
                i--;
                flag = true;
            }
        }
        return ans;
    }
}
