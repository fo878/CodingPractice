package com.OJ.IO;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestIO {
    @Test //输入为一个字符串
    public void test1() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();
        // 测试输入是否正确
        System.out.println(line);
    }
    @Test //输入为多个数字
    public void test2() throws IOException{
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出

        //parseInt:将字符串参数解析为带符号的十进制整数。
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        // 测试输入是否正确
        System.out.println("n: " + n + "\tv: " + v);
    }
    @Test //若输入中有一个数组，且有数组的长度
    /*
    * 例如：
    * 7 6
    * 1 2 3 4 5 6 7
    * */
    public void test3() throws IOException{
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        // 读取第二行数据
        line = br.readLine();
        //trim()返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        //split()将此字符串分割为给定的 regular expression的匹配。
        strings = line.trim().split(" ");
        // 创建一个int型的数组用来储存第二行的多个数字
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        // 测试输入是否正确
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test4() throws IOException{
        //输入为一个字符串,字符串全是整数用空格隔开
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test5() throws IOException{
        //输入一个3行4列的二维数组
        /*
            3 4
            1 2 3 4
            2 3 4 5
            3 4 5 6
        * */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        //打印二维数组，m行，n列
        for (int i=0 ; i<m ; i++) {
            for(int j=0 ;j<n ;j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.println( );
        }
    }

    @Test
    public void test6() throws IOException{
        //输入任意矩阵
        /*
            "1,2,3;4,5,6;7,8,9"
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String s = line.substring(1,line.length()-1);
        int[][] d;
        String[] sFirst=s.split(";");
        d=new int[sFirst.length][];
        for(int i=0;i<sFirst.length;i++){
            String[] sSecond=sFirst[i].split(",");
            d[i]=new int[sSecond.length];
            for(int j=0;j<sSecond.length;j++){
                d[i][j]=Integer.parseInt(sSecond[j]);
            }
        }

        for(int i=0;i<d.length;i++){
            for(int j=0;j<d[i].length;j++){
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test7() throws IOException{
        //输入任意矩阵
        /*
            {{1,2,3,4},{2,3,4,5},{3,4,5,6}}
            先转化成
            1,2,3;4,5,6;7,8,9
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String s = line.substring(2,line.length()-2).replaceAll("\\{", "").replaceAll("},", ";");
        int[][] d;
        String[] sFirst=s.split(";");
        d=new int[sFirst.length][];
        for(int i=0;i<sFirst.length;i++){
            String[] sSecond=sFirst[i].split(",");
            d[i]=new int[sSecond.length];
            for(int j=0;j<sSecond.length;j++){
                d[i][j]=Integer.parseInt(sSecond[j]);
            }
        }

        for(int i=0;i<d.length;i++){
            for(int j=0;j<d[i].length;j++){
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
    }
}
