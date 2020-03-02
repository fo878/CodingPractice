package com.OJ.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 有一点要注意的是，由于在IO时所用的方法往往是有声明必检异常的，所以这里如果不想在代码中加入try-catch块的话，
*  main()方法也要声明抛出’IOException`异常。
* */
public class Main {
    public static void main(String[] args) throws IOException{
        /*
         * 输入为一个字符串
         * */
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();
        // 测试输入是否正确
        System.out.println(line);
    }
}

