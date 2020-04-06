package com.nowcoder.box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 我们有一堆商品，要装到箱子中。已知箱子的容积是3，也知道每个商品的体积。
* 不考虑商品的形状，假设只要N个商品的体积加和，恰好是3，就可以装进箱子。
* 而且，如果商品的体积超过了3，只要恰好是箱子体积的倍数，可以把多个箱子拼成1个大箱子，来装商品。
比如：2个商品，体积加起来是6，可以用2个箱子来装载。
如果加起来是7，就不行了，必须得扔掉某个商品，再继续看能不能装进去。
找出一批商品，恰好装满M个箱子。你能找到的最大的M，是多少？
* input:各商品的体积
* output:选出商品需要装的箱子个数
* */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(maxSumDivThree(nums)/3);
    }

    public static int maxSumDivThree(int[] nums){
        int ans = 0,sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        Arrays.sort(nums);
        if (sum%3==0) {return sum;}
        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i])%3 == 0){
                ans = Math.max(ans,sum-nums[i]);
            }
            for (int j = i+1; j < nums.length; j++) {
                if ((sum-nums[i]-nums[j])%3 == 0){
                    ans = Math.max(ans,sum-nums[i]-nums[j]);
                    break;
                }
            }
        }
        return ans;
    }
}
