package com.wzy.algorithms.offer.no00010;

import java.util.Arrays;
import java.util.HashMap;

/**
 * FileName: Solution
 * Description:
 * Author: wangzhenyue
 * Date: 2023/6/26 10:43
 */
public class Solution {

    //采用原始的滑动窗口思想解决，但是覆盖不够全面，按照以下的解法仅适合正整数数组
    public static int subarraySum1(int[] nums, int k) {

        int n = nums.length;
        int i = 0;
        int ans = 0;
        int sum = 0;

        for(int j = 0; j < n; j++){
            sum += nums[j];

            while(i <= j && sum > k && n > 1){
                sum -= nums[i];
                i++;
            }
            if(sum == k){
                ans += 1;
            }
        }
        return ans;

    }

    //使用前缀和+哈希表的方式解决
    public static int subarraySum(int[] nums, int k) {
        //初始化
        int n = nums.length;
        int pre = 0; // 子数组和
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); //引入哈希表，子数组和作为key, 子数组和出现的次数作为value
        int ans = 0; // 返回结果
        hm.put(0,1); //初始化哈希表，因为pre有初始值

        for(int j = 0; j < n; j++){
            pre += nums[j]; //累加和
            if(hm.containsKey(pre - k)){
                ans += hm.get(pre-k); //pre-k出现的次数就是满足和为k的子数组的个数
            }
            hm.put(pre, hm.getOrDefault(pre,0)+1);
        }
        return ans;

    }

    public static void main(String[] args){
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }

}
