package com.leetcode.DataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 830. 较大分组的位置
* 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
* */
class largeGroupPositionsSolution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        for (int left=0,right=0; right <= n ; right++) {
            if (right==n || s.charAt(left) != s.charAt((right))) {
                if (right-left >= 3) {
                    res.add(Arrays.asList(left,right-1));
                }
                left = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abbxxxxzzy"; //[0,0] [1,2] [3,6] [7,8] [9,9]
        largeGroupPositionsSolution foo = new largeGroupPositionsSolution();
        List<List<Integer>> lists = foo.largeGroupPositions(s);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).toString());
        }
    }
}