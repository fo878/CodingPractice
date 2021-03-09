package com.leetcode.DataStructure.array;

import java.util.PriorityQueue;

public class lastStoneWeightSolution {
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a>b) {
                pq.offer(a-b);
            }
        }
        return pq.isEmpty()? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        lastStoneWeightSolution foo = new lastStoneWeightSolution();
        System.out.println(foo.lastStoneWeight(stones));
    }
}
