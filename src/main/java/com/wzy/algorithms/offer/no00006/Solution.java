package com.wzy.algorithms.offer.no00006;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Solution
 * Description: 输出数组中两数之和等于给定target的下标
 * Author: wangzhenyue
 * Date: 2023/6/8 13:51
 */
public class Solution {

    public static int[] twoSum(int[] numbers, int target) {
        //哈希表
        int n = numbers.length;
        Map sumSet = new HashMap();
        for(int i = 0; i < n; ++i){
            if(sumSet.containsKey(target-numbers[i])){
                int ans = (Integer) sumSet.get(target-numbers[i]);
                return new int[]{ans, i};
            }
            sumSet.put(numbers[i],i);
        }
        return numbers;

    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int[] ret = twoSum(numbers,6);
        System.out.println(ret[0]+ret[1]);
    }
}
