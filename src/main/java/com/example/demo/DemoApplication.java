package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ListNode l1=new ListNode(0);
        ListNode head1=l1;
        head1.next=new ListNode(10);
        head1=head1.next;
        head1.next=new ListNode(1);
        head1=head1.next;
        head1.next=new ListNode(9);
        head1=head1.next;
        head1.next=new ListNode(2);
        head1=head1.next;
        head1.next=new ListNode(8);
        head1=head1.next;
        head1.next=new ListNode(3);
        head1=head1.next;
        Solution s=new Solution();
        ListNode res=s.mySort(l1);

        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
//        SpringApplication.run(DemoApplication.class, args);

    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
class Solution{
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dumyList=new ListNode(-1);
        ListNode now=dumyList;
        while(l1!=null || l2!=null){
            if(l1==null){
                now.next=l2;
                break;
            }else if(l2==null){
                now.next=l1;//a
                System.out.println("bbb");
                break;
            }else{
                if(l1.val<=l2.val){
                    now.next=l1;
                    l1=l1.next;
                }else{
                    now.next=l2;
                    l2=l2.next;
                }
            }
            now=now.next;
        }
        return dumyList.next;
    }
    public ListNode mySort(ListNode head){
        ListNode l1=head;
        ListNode head2=head.next;
        ListNode l2=head2;
        while(l2!=null && l2.next!=null){
            l1.next=l2.next;
            l1=l1.next;
            l2.next=l1.next;
            l2=l2.next;
        }

        ListNode pre=null;
        l2=head2;
        while(l2!=null){

            ListNode tmp=l2.next;
            l2.next=pre;
            pre=l2;
            l2=tmp;
        }
        head2=pre;
        return merge(head,head2);
    }
}