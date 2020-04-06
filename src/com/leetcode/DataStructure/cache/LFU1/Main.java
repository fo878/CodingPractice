package com.leetcode.DataStructure.cache.LFU1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int capacity = 2;
        LFUCache1 cache = new LFUCache1(capacity);
        int[] out = new int[10];
        int i = 0;
//        obj.put(2, value);
//        int param_1 = obj.get(key);
        cache.put(1, 1);
        cache.put(2, 2);
        out[i++] = cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        out[i++] = cache.get(2);       // 返回 -1 (未找到key 2)
        out[i++] = cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        out[i++] = cache.get(1);       // 返回 -1 (未找到 key 1)
        out[i++] = cache.get(3);       // 返回 3
        out[i++] = cache.get(4);       // 返回 4
        System.out.println(Arrays.toString(out));
    }
}
