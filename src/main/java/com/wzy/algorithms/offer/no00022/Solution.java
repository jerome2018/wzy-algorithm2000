package com.wzy.algorithms.offer.no00022;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Description: 返回链表中环的入口节点
 * Author: wangzhenyue
 * Date: 2023/7/21 16:20
 */
public class Solution {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> nodeSet = new HashSet<>(); //定义哈希表，利用其不可重复的特性
        while(pos != null){
            if(nodeSet.contains(pos)){
                return pos;
            }else{
                nodeSet.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }



    public static void main(String[] args){

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; //测试时一定把pos的索引指出来


        ListNode ans = detectCycle(head);
        System.out.println(ans.val);
    }
}
