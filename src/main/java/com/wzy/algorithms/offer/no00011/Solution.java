package com.wzy.algorithms.offer.no00011;

import java.util.HashMap;

/**
 * FileName: Solution
 * Description: 找出含有0和1相同个数的最长连续子数组，返回其长度
 * Author: wangzhenyue
 * Date: 2023/6/27 10:24
 */
public class Solution {

    //前缀和+哈希表的思想，但是构建前缀和需要一点巧妙的思维，如题干中0和1数量相同的连续子数组可以理解为其和为0的连续子数组，仅需把0看做-1
    public static int MaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int pre = 0;
        int ans = 0;
        int preIndex = 0;
        hm.put(pre, -1); // 这个初始值代表没有符合要求的子数组，其长度也就是0， 但我们把数组中的0统一按照-1理解，所以这里设置为-1

        for(int j=0; j<n; j++){
            if(nums[j] == 1){
                pre += nums[j];
            }else{
                pre -= 1;
            }
            if(hm.containsKey(pre)){
               preIndex = hm.get(pre);
               ans = Math.max(ans, j-preIndex); //目标子数组的长度，取最大值
            }else{
                hm.put(pre,j);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(MaxLength(nums));
    }
}
