// Brute Force, Time - O(kn^2), O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) {
            return null;
        }
        
        ListNode result = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list : lists) {
            result = merge(result, list);
        }
        
        return result.next;
        
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val > l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            }
            else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        
        if(l1!=null) {
            dummy.next=l1;
        }
        
        if(l2!=null) {
            dummy.next=l2;
        }
        
        return result.next;
    }
}
