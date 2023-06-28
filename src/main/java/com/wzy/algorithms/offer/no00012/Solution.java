package com.wzy.algorithms.offer.no00012;

import java.util.Arrays;

/**
 * FileName: Solution
 * Description: 找出数组的中心下标，使其左右两侧元素之和相同
 * Author: wangzhenyue
 * Date: 2023/6/28 14:01
 */
public class Solution {

    //采用前缀和思想，假设中心下标为i, 则左侧和left+nums[i]+right=total, 如果满足条件，则left=right
    public static int pivotIndex(int[] nums) {

        int n = nums.length;
        int sum = 0; // 左侧之和，或者称为右侧之和，只有左侧之和与右侧之和相等时，才能找到对应的符合条件的中心下标
        int total = Arrays.stream(nums).sum();

        for(int i = 0; i < n; i++){
            if(2*sum + nums[i] == total){
                return i; //这个中心下标本来是从左边开始遍历的，所以即时有多个中心下标，得到的下标应该是最靠左边的
            }
            sum += nums[i];
        }
        return -1;

    }






    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
