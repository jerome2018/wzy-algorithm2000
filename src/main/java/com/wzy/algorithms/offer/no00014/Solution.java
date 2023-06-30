package com.wzy.algorithms.offer.no00014;

import java.util.Arrays;
import java.util.HashMap;

/**
 * FileName: Solution
 * Description: 判断字符串中的变位串,即s1的排列之一是s2的子串
 * Author: wangzhenyue
 * Date: 2023/6/30 10:36
 */
public class Solution {

    //通过滑动窗口，固定滑动窗口长度为n
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        //定义两个数组，分别存放字符串s1和s2中每个字符出现的次数，由于字符总共26个
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < n; i++){
            //遍历字符串，数组元素为统计字符串中每个字符出现的次数（a~z）
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1, cnt2)){
            return true;
        }

        //滑动窗口，为了保证长度为n，平移时，右边字符进入窗口，左边字符离开窗口
        for(int j = n; j < m; j++){
            ++cnt2[s2.charAt(j) - 'a'];
            --cnt2[s2.charAt(j-n) - 'a'];
            if(Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }



        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab",s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
