package com.wzy.algorithms.offer.no00024;

/**
 * FileName: Solution
 * Description: 反转链表
 * Author: wangzhenyue
 * Date: 2023/7/25 16:13
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode cur = head;
        //本质是暂存前驱节点和后继节点，对原指针改变方向
        while(cur != null){
            ListNode temp = cur.next; //存储后继节点
            cur.next = revHead; //指针反向操作

            //遍历向后执行
            revHead = cur; //反转后的头节点也需要每遍历一次，向后走一步
            cur = temp; //原链表的遍历

        }
        return revHead;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
