import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.add(2); list1.add(3);
        ListNode list2 = new ListNode(1);
        list2.add(3);list2.add(4);


        System.out.println(mergeTwoLists(list1,list2));
    }

    static class ListNode {
        int val;
        ListNode next;

        public void add(int val){
            // if next is null, create a new ListNode with the num as its param
            // set new ListNode as next
            // else tell next to add number
            if(next == null){
                next = new ListNode(val);
            }
            else next.add(val);
        }

        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }

        private String getChildren(String existingChildren){
            existingChildren += val;
            if(next != null){
                existingChildren += ",";
               return next.getChildren(existingChildren);
            }
            else {
                return existingChildren + "]";
            }
        }

        @Override
        public String toString() {
            return getChildren("[");
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        if(list1 == null && list2 == null) return null;
        // merge the array from list1 to the val from list2 in to one bigger array
        // carry out a nerge sort on the bigger array
        // create a new ListNode who val is the sorted bigger array

        while(list1!= null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1!=null){
            cur.next = list1;
        }

        if(list2!=null){
            cur.next = list2;
        }
        return dummy.next;
    }
}
