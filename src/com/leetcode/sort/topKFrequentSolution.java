package com.leetcode.sort;

import java.util.*;

public class topKFrequentSolution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();

        for (int i : nums) {
            frequent.put(i, frequent.getOrDefault(i, 0) + 1);
        }
        // key-value倒置，并对key倒序排
        Map<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.comparing(Integer::intValue).reversed());
        for (Map.Entry<Integer, Integer> entry : frequent.entrySet()) {
            List<Integer> valueList = treeMap.getOrDefault(entry.getValue(), new ArrayList<>());
            if (!valueList.contains(entry.getKey())) valueList.add(entry.getKey());
            treeMap.put(entry.getValue(), valueList);
        }
        // 顺序输出结果
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            if (data.size() < k) data.addAll(entry.getValue());
        }

        int[] res = new int[data.size()];
        Object[] objects = data.toArray();
        for (int i = 0; i < res.length; i++) {
            res[i] = (int)objects[i];
        }
        return res;
    }
}