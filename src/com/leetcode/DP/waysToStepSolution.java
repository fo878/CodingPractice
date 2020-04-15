package com.leetcode.DP;
/*
* 三步问题。
* 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
* 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class waysToStepSolution {
    public static int waysToStep(int n) {
        if (n < 3){
            return n;
        }else if (n==3){
            return 4;
        }else {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i < n+1; i++) {
                //取余公式： (a + b + c)%p = ((a%p + b%p)%p + c%p)%p
                dp[i] = ((dp[i-1]%1000000007 + dp[i-2]%1000000007)%1000000007 + dp[i-3]%1000000007)%1000000007;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {

        System.out.println(waysToStep(61));// 752119970
    }
}
