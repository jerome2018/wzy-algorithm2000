package com.wzy.algorithms.offer.no00009;

/**
 * FileName: Solution
 * Description: 给定一个正整数数组和一个固定值K,找出乘积小于K的连续子数组的个数
 * Author: wangzhenyue
 * Date: 2023/6/25 13:44
 */
public class Solution {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //初始思路分析：
        //1.子数组的长度分别是1,2，...直到nums.length
        //2.通过简单遍历数组分别比较给定K值，貌似不可取，复杂度过高

        //新的思路，二分查找,理解起来需要点繁琐的数学知识，而且思维比较刻意，不容易形成一定的推理逻辑，不是很推荐这种解法

        //采用滑动窗口解决，定义窗口起止点i,j
        int n = nums.length, ans = 0;
        int prod = 1; int i = 0;

        for(int j = 0; j<n; j++){
            prod *= nums[j];
            //判断是否符合条件，如窗口起止点要保证起点在终点左边或重合，重合就是单元素数组，另一个就是满足乘积小于k,也就是大于等于k就退出
            while(i <= j && prod >= k){
                prod /= nums[i]; //乘积太大，进行滑动窗口，除以nums[i],然后右移左端点
                ++i; //右移左端点
            }
            ans += j-i+1;
        }
        return ans;

    }


    public static void main(String[] args){
        System.out.println("-----------starting to code-------------");
        int[] nums = {10,5,2,6};
        int k = 100;
        int ans = numSubarrayProductLessThanK(nums,k);
        System.out.println(ans);
    }
}
