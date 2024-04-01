package other;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        int carry = 0;
        // Sum list intialization with value
        int s = l1.val+l2.val;
        if(s>=10){
            carry=1;
            sum.val = s-10;
        }else{
            carry=0;
            sum.val=s;
        }
        // making pointers for each list
        ListNode p1=l1,p2=l2,ps=sum;
        // Looping all the nodes and adding value if both nodes are not null
        while (p1 != null && p2 != null) {
            int i = p1.val;
            int j = p2.val;
            int temp = i + j + carry;
            if (temp >= 10) {
                carry = 1;
                ps.next = new ListNode(temp - 10);
            } else {
                carry = 0;
                ps.next = new ListNode(temp);
            }
            p1 = p1.next;
            p2 = p2.next;
            ps = ps.next;
        }
        // adding individual values for p1
        while (p1 != null) {
            int i = p1.val;
            int temp = i + carry;
            if (temp >= 10) {
                carry = 1;
                ps.next = new ListNode(temp - 10);
            } else {
                carry = 0;
                ps.next = new ListNode(temp);
            }
            p1 = p1.next;
            ps = ps.next;
        }
        while (p2 != null) {
            int i = p2.val;
            int temp = i + carry;
            if (temp >= 10) {
                carry = 1;
                ps.next = new ListNode(temp - 10);
            } else {
                carry = 0;
                ps.next = new ListNode(temp);
            }
            p2 = p2.next;
            ps = ps.next;
        }
        // adding individual values for p2
        return sum;
    }
}