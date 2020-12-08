package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
*75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

本题是经典的「荷兰国旗问题」，由计算机科学家 Edsger W. Dijkstra 首先提出。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class sortColorsSolution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n-1;
        for (int i = 0; i <= p2 ; i++) {
            while(i<=p2 && nums[i]==2) {
                swap(nums,i,p2);
                p2 -= 1;
            }
            if (nums[i] == 0) {
                swap(nums,i,p0);
                p0 += 1;
            }
        }
    }

    public int[] swap(int[] nums,int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColorsSolution foo = new sortColorsSolution();
//        foo.swap(nums,0,1);
//        System.out.println(Arrays.toString(nums));
        foo.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
