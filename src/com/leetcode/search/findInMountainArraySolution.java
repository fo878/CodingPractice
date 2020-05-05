package com.leetcode.search;
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 *
 * （这是一个 交互式问题 ）
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * 首先，A.length >= 3
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

interface MountainArray {
    public int get(int index);
    public int length();
}

class MountainArrayImpl implements MountainArray{

    public int[] arr;
    public int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return size;
    }
}

public class findInMountainArraySolution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        // 步骤 1：先找到山顶元素所在的索引
        int mountainTop =  findMountaintop(mountainArr,0,size-1);
        // 步骤 2：在前有序且升序数组中找 target 所在的索引
        int res = findFromSortedArr(mountainArr,0,mountainTop,target);
        if (res != -1){
            return res;
        }else {// 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
            return findFromInversedArr(mountainArr,mountainTop+1,size-1,target);
        }
    }

    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
        if (mountainArr.length()==0){
            return -1;
        }
        int mid;
        while (l<=r){
            mid = l+(r-l)/2;
            if (mountainArr.get(mid)==target) return mid;
            if (target<mountainArr.get(mid)){
                r = mid-1;
            }else l = mid+1;
        }
        return -1;
    }

    private int findFromInversedArr(MountainArray mountainArr, int l, int r, int target) {
        if (mountainArr.length()==0){
            return -1;
        }
        int mid;
        while (l<=r){
            mid = l+(r-l)/2;
            if (mountainArr.get(mid)==target) return mid;
            if (target>mountainArr.get(mid)){
                r = mid-1;
            }else l = mid+1;
        }
        return -1;
    }

    private int findMountaintop(MountainArray mountainArr, int l, int r) {
        while (l<r){
            int mid = l+(r-l)/2;
            if (mountainArr.get(mid)<mountainArr.get(mid+1)){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        MountainArray mountainArray = new MountainArrayImpl(arr);
        findInMountainArraySolution foo = new findInMountainArraySolution();
        System.out.println(foo.findInMountainArray(target,mountainArray));
    }
}
