package com.leetcode.calculation;

public class mySqrtSolution {
    public int mySqrt(int x) {
        return (int)Math.pow((double)x,0.5);
    }

    public int mySqrt1(int x){
        int l = 0;
        int r = x;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if ((long)mid*mid <= x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        //牛顿迭代法   xi = 0.5 * (x0 + C / x0)
/*  作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }



    public static void main(String[] args) {
        int x = 8;
        int y = 4;
        mySqrtSolution foo = new mySqrtSolution();
        System.out.println(foo.mySqrt(x));
        System.out.println(foo.mySqrt(y));
        System.out.println(foo.mySqrt1(x));
        System.out.println(foo.mySqrt1(y));
    }
}
