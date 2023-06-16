package com.wzy.algorithms.offer.no00001;

/**
 * FileName: Solution
 * Description: 两个整数的除法（不能用乘号，除号及求余）
 * Author: wangzhenyue
 * Date: 2023/2/22 15:49
 */
public class Solution {

    public static void main(String[] args){
        System.out.println("---------starting two int divide-------");
    }

    public static int divide(int a, int b){
        /**
         * 边界条件判断，除法约定：被除数/除数 = 商
         * 边界1：被除数为-2^31,除数为-1时，商理论上是2^31,但是题目规则操作数值范围是32位有符号的整数
         * 边界2：除数为-2^31时，除数为非-2^31时，结果均为0
         * 边界3：除数为0是非法计算，统一返回0
         */
        //判断溢出条件，a为负数最大值，b为-1
        if(a == Integer.MAX_VALUE  && b == -1){
            return Integer.MAX_VALUE;
        }
        return 0;

    }
}
