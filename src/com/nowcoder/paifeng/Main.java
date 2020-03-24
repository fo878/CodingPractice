package com.nowcoder.paifeng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
便利蜂的门店里，有一个鲜食制作的区域。这个区域里，每天早晨、中午、晚上的一些时段，会制作早饭、午饭、晚饭的热餐。
当前，我们开展一个能耗节约的项目，需要动态控制这个鲜食制作区域里的排风装置。控制的策略上，是如下的两个约束条件：
1) 在全部的鲜食制作时间段内、制作时间段前后30分钟，开启排风装置（将制作区域里因制作导致的热空气抽出去）；其他时间段，关闭排风装置。
2) 为了避免排风装置的频繁启停，我们规定排风装置的每一段关闭时间段长度应大于60分钟，否则就不予关闭；即，如果关闭时间不足60分钟，则保持开启状态。
举个例子：
一家门店的制作时间段是：
[05:30, 07:30), [10:30, 11:30), [12:30, 13:00), [16:30, 17:30)
按照上述规则，我们的排风装置应该在如下时间段打开，其他时间关闭：
[05:00, 08:00), [10:00, 13:30), [16:00, 18:00)
我们精确到分钟，每天按照 1440 分钟来计算，上述的时间段则分别对应了如下的输入、输出：
Input:  [330, 450, 630, 690, 750, 780, 990, 1050]
Output: [300, 480, 600, 810, 960, 1080]
构造一个算法，完成 Input => Output 的计算过程。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
            if (i%2==0){
                array[i] -= 30;
            }else {
                array[i] += 30;
            }
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array[i]-1; i++) {
            int j = i+1;
            if (array[i] >= array[j]){
                array[i] = 0;
                array[j] = 0;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0){
                sb.append(array[i]).append(',');
            }
        }
        String out = sb.toString().substring(0,sb.length()-1);
        System.out.println(out);//300,480,600,810,960,1080
    }
}
