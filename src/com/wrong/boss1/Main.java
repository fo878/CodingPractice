package com.wrong.boss1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 编写一个多线程程序
* 输入参数为线程数K和整数N，K>=2,N>=2
* 按顺序输出 1:1 2:2   。。。 k：n
* 每个线程只负责输出特定尾号的数字，k号线程只负责输出满足（n%k == k）的数字
* */

class MyThread extends Thread{

    private int k;
    private int N;
    private int n=0;

    public MyThread(String name,int N) {
        super(name);
        k = Integer.parseInt(name);
        this.N = N;
    }

    public void run(){
//        System.out.println(MyThread.currentThread().getName());
//        System.out.println(MyThread.currentThread().getName() + " 当前线程的n："+ n);
//        System.out.println(MyThread.currentThread().getName() + " 当前线程的k："+ k);

        if (n%k == k){
            System.out.print(MyThread.currentThread().getName()+":"+n);
        }
        n++;
    }
}

public class Main {
    private int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int K = Integer.parseInt(strings[0]);
        int N = Integer.parseInt(strings[1]);
        Thread thread[] = new Thread[K];
        for (int i = 0; i < K; i++) {
            thread[i] = new MyThread(Integer.toString(i+1),N);
            thread[i].start();
        }
    }
}
