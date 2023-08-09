package com.wzy.algorithms.offer.no00027;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Description: 回文链表
 * Author: wangzhenyue
 * Date: 2023/7/31 15:26
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(){};
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        //把链表数据放入数组当中，可以利用数组的查找性能
        List<ListNode> tmpList = new ArrayList<>();
        while (head != null){
            tmpList.add(head);
            head = head.next;
        }
        //采用双指针向中间移动
        int l = 0;
        int r = tmpList.size() - 1;
        while(l < r ){
            if(tmpList.get(l).val != tmpList.get(r).val){
                return false;
            }
            l++;
            r--;
        }
        return true;



    }



    public static ListNode reverse(ListNode head) {
        /*ListNode reverse = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = reverse;

            reverse = current;
            current = temp;
        }
        return reverse;*/

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
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        System.out.println(isPalindrome(head));
    }
}
