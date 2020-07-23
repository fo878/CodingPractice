package com.leetcode.DataStructure.array;

import java.util.*;

/*
* 面试题 16.11. 跳水板
* 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
* 长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
* 返回的长度需要从小到大排列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diving-board-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class divingBoardSolution {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k==0) return new int[]{};
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i <= k ; i++) {
            set.add(shorter * (k-i) + longer * i);
        }
        int[] ans = new int[set.size()];int j = 0;
        for (Integer integer : set) {
            ans[j++] = integer;
        }
        return ans;
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        // 官方题解
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }


    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 3;
        String out = Arrays.toString(divingBoard(shorter,longer,k));
        System.out.println(out);
    }
}
