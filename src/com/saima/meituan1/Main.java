package com.saima.meituan1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
//        System.out.println(line1);
//        System.out.println(line2);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        String[] strings = line2.trim().split(" ");
        for (int i = 0; i < strings.length; i++) {
            map.put(i+1,Integer.parseInt(strings[i]));
        }
        StringBuffer res = new StringBuffer();
        Main foo = new Main();
        char[] chars = line1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                res.append('-');
            }
            else {
                res.append(map.get(chars[i]-'0'));
            }
        }
        System.out.println(res.toString());
    }
}
