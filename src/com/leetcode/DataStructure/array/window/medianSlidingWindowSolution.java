package com.leetcode.DataStructure.array.window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class medianSlidingWindowSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            //先把前k个插入到数据结构中
            dualHeap.insert(nums[i]);
        }

        double[] ans = new double[nums.length-k+1];//一共有n-k+1个窗口

        ans[0] = dualHeap.getMedian();

        for (int i = k; i < nums.length ; i++) {
            //每次都把最前边的清除了，加上最后边的
            dualHeap.insert(nums[i]);
            dualHeap.erase(nums[i-k]);
            ans[i-k+1] = dualHeap.getMedian();
        }
        return ans;
    }
}

//大根堆、小根堆构造一个数据结构
class DualHeap {
    //大根堆维护较小一半的元素
    private PriorityQueue<Integer> small;
    //小根堆维护较大一半的元素
    private PriorityQueue<Integer> large;
    //哈希表来记录延迟删除的元素 key为元素，value为需要删除的次数
    private Map<Integer,Integer> delayed;

    private int k;//small和large 当前包含的元素个数，需要扣除被延迟删除的元素
    private int smallSize;
    private int largeSize;

    /**
     * 构造方法
     * @param k
     */
    public DualHeap(int k) {
//        this.large = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
//        this.small = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2.compareTo(num1);
            }
        });
        this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2);
            }
        });

        this.delayed = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    /**
     * 获得中位数的方法
     */
    public double getMedian(){
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    //插入方法
    public void insert(int x) {
        if (small.isEmpty() || x <= small.peek()) {
            //在小根堆范围内，就插入到小根堆中
            small.offer(x);
            smallSize += 1;//更新小根堆的大小
        } else {
            large.offer(x);
            largeSize += 1;
        }
        makeBalance();//保持堆的平衡
    }

    //延迟擦除方法,因为优先队列每次只能删除栈顶元素，
    // 就只能等栈顶元素被清除时，一次性把之前需要清除的都清除了
    public void erase(int num) {
        delayed.put(num,delayed.getOrDefault(num,0) + 1);
        if (num <= small.peek()){
            smallSize -= 1;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            largeSize -= 1;
            if (num == large.peek()) {
                prune(large);
            }
        }
        makeBalance();
    }

    private void makeBalance() {
        if (smallSize > largeSize + 1) {
//          左边比右边多2个，左边顶到右边
            large.offer(small.poll());
            smallSize -= 1;
            largeSize += 1;
            prune(small);
            //small 堆顶的元素被移除
        } else if (largeSize > smallSize) {
            small.offer(large.poll());
            smallSize += 1;
            largeSize -= 1;
            prune(large);
        }
    }

    //不断地弹出heap的对顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num,delayed.get(num)-1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }
}