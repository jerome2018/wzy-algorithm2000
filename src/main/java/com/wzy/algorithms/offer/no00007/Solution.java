package com.wzy.algorithms.offer.no00007;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: Solution
 * Description: 输出给定数组中和为0的三个数
 * Author: wangzhenyue
 * Date: 2023/6/2 13:28
 */
public class Solution {

    //返回结果应该是个三元组
    public static List<List<Integer>> threeSum(int[] nums) {

        //先对数组进行排序
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        //第一重遍历数组
        for(int first = 0 ; first < n; ++first){
            //保证枚举数组相邻元素不要重复,first>0是为了防止数组越界
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            //定义右指针
            int right = n - 1;
            int target = -nums[first]; //这句代码是精髓，约定个目标值，其与nums[first]相加=0

            //第二重遍历有，second相当于双指针的左指针
            for(int second = first + 1; second < n; ++second){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                //保证左指针second在右指针right的左边，及左移右指针
                while(second < right && nums[second] + nums[right] > target){
                    --right;
                }

                if(second == right ){
                    break;
                }

                if(nums[second] + nums[right] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[right]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args){
        /*System.out.println("starting to code---------");
        int[] nums = {1,4,9,-1,3,-2,0};
        List<List<Integer>> ret = threeSum(nums);
        System.out.println(ret.toString());
*/

        Double amount1 = 1.2;
        int amount = 2;
        String ss = "2";
        Object ww = 1;
        BigDecimal bd = new BigDecimal(0.1);
        BigDecimal bd1 = BigDecimal.valueOf((Double) ww);


       // BigDecimal bd = new BigDecimal((String)data.get("amount"));
        System.out.println(bd1);
    }
}
