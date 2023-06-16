package com.wzy.algorithms.offer.no00008;

import java.util.Arrays;

/**
 * FileName: Solution
 * Description: 给定一个正整数数组，找出满足其和大于等于给定值的最小长度的连续子数组，返回其长度
 * Author: wangzhenyue
 * Date: 2023/6/12 13:20
 */
public class Solution {

    public static int minSubArrayLen(int target, int[] nums) {
        /*//可以对数组进行排序处理吗，不可以，因为就会改变数组的原始顺序，就无法找到连续子数组了
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            //这种方式是按照顺序遍历找到符合条件的子数组，但是找不到最短长度的
            if(sum  >= target){
                return i;
            }
            sum += nums[i];
        }*/

        //使用滑动窗口的方法解决
        int n = nums.length;
        int start=0,end=0,sum = 0; //start,end起点相同，end每次遍历均右移，start满足条件才右移
        int ans = Integer.MAX_VALUE; //初始化为整数的最大值

        //注意这个外层while循环，最多执行n次
        while(end < n){
            sum += nums[end];

            //右移start指针的条件
            while(sum >= target ){ //内层while循环，由于target是个常数，所以执行次数是常量级
                sum -= nums[start]; //满足该条件说明和sum有点太大，需要减去nums[start]
                ans = Math.min(ans, end-start+1);
                ++start;
            }
            ++end; //默认右移end
        }
        return ans == Integer.MAX_VALUE? 0 :ans;
    }

    public static void main(String[] args){
        System.out.println("-----------starting to code----------");
        int[] nums = {2,3,1,2,4,3};
        int ans = minSubArrayLen(7,nums);
        System.out.println(ans);
    }
}
