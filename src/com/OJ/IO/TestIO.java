package com.OJ.IO;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
