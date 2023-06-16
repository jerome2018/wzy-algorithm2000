package com.wzy.algorithms.leetcode.no00206;

import com.wzy.algorithms.common.ListNode;

/**
 * FileName: Solution
 * Description:反转一个单链表,给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * Author: wangzhenyue
 * Date: 2023/3/30 15:24
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {
        //定义一个新head，初始值是null,同时也是当前链表头节点的前继节点
        ListNode prev = null;
        //定义当前链表，用于遍历使用
        ListNode cur = head;
        //遍历链表
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            //开始往后遍历一个节点,ben
            prev = cur;
            cur = next;
        }
        return prev;

    }


    public static void main(String[] args){
        System.out.println("---------start coding------");
        //定义链表节点数据
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        //把节点用指针连接起来
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        ListNode ret = reverseList(head);
        System.out.println(ret.toString());
//        while(ret != null){
//            System.out.print(ret.val);
//            ret = ret.next;
//        }
    }
}
