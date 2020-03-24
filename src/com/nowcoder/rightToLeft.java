package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class rightToLeft {

    /*
    * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
    * */
    public static void main(String[] args)throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();
        StringBuffer lineBuffer = new StringBuffer(line);
        line = lineBuffer.reverse().toString();
        LinkedList<Character> list = new LinkedList<Character>();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!list.contains(chars[i])){
                list.add(chars[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!list.isEmpty()){
            sb.append(list.poll());
        }
        System.out.println(sb);
    }
}
