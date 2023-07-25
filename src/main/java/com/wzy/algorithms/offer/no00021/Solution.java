package com.wzy.algorithms.offer.no00021;

/**
 * FileName: Solution
 * Description: 删除链表倒数第n个节点，返回链表的头节点
 * Author: wangzhenyue
 * Date: 2023/7/20 11:25
 */
public class Solution {

    //定义一个链表节点
    public static class ListNode{
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

    //采用辅助计算，寻找待删除节点的前驱节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); //增加一个虚节点辅助遍历，相当于在原头节点前面增加了一个节点
        int len = getLength(head);
        ListNode cur = dummy;
        for(int i = 1; i < len - n + 1; i++){//第len-n+1个节点正是要删除的倒数第n个节点
            cur = cur.next;
        }
        cur.next = cur.next.next; //删除了cur.next指向的节点
        ListNode ans = dummy.next;
        return ans;

    }

    //采用双指针
    public static ListNode removeNthFormEnd1(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 0; i < n; i++){//遍历到第n个节点
            first = first.next;
        }

        while(first != null){//双指针处于不同的起点，同时遍历，当first到达结尾时，second刚是倒数第n-1个点
              first = first.next;
              second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }



    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null){
            ++length;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 =  new ListNode(2);
        ListNode node2 =  new ListNode(3);
        ListNode node3 =  new ListNode(4);
        ListNode node4 =  new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode ans = removeNthFormEnd1(head, 2);
        StringBuffer sb = new StringBuffer(ans.val);
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
