package com.leetcode.DataStructure.array;
/*
* 未完成
* */
import java.util.Arrays;
import java.util.HashSet;

/*
* 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
* 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    输入: [1,2,3,4,5]
    输出: True
 
* 分析：
您不妨先思考一个这样的问题：
有一串连续的数字（无重复），这串数字中最大值为 m， 最小值为 n ，问你这串数字中一共有多少个数字？

答案：
    m - n + 1

同样，如果我们能够知道 5 张扑克牌中的最大值 maxValue 和最小值 minValue ，
那我们就知道，要使它为顺子需要 maxValue - minValue + 1 张牌。

在查找 maxValue 和 minValue 过程中，跳过大小王 00 。
如果 maxValue - minValue + 1 > 5，说明题目给的 5 张牌不足以构成顺子，返回 false .
即使里面有大小王，也不够用来填补使它构成顺子。
如果 maxValue - minValue + 1 <= 5，说明 5 张牌足以构成顺子，返回 true。
里面的大小王填补在合适位置即可。
同时，我们再定义一个标志数组判断是否有重复数字，发现重复数字直接返回 false 即可。

作者：huwt
链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/bu-ke-pai-zhong-de-shun-zi-pai-xu-fang-shi-he-bu-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*
* */
public class isStraightSolution {
    public boolean isStraight(int[] nums) {
        int minValue = 13;//扑克牌最大的是K
        int maxValue = nums[0];
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i]<minValue){
                minValue = nums[i];
            }
            if (nums[i]>maxValue){
                maxValue = nums[i];
            }
            if (!set.add(nums[i])){
                return false;
            }
        }
        return maxValue - minValue + 1 <= 5;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,5};
        isStraightSolution foo = new isStraightSolution();
        System.out.println(foo.isStraight(nums));
    }
}
