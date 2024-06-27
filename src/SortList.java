class SortList {
    public static void main(String[] args) {
            ListNode list1 = new ListNode(1);
            ListNode list2 = new ListNode(2);

            System.out.println(merge(list1,list2));

    }
      //Definition for singly-linked list.
        static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        private static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // Split list in half
            ListNode middle = getMiddle(head);
            ListNode nextOfMiddle = middle.next;
            middle.next = null;

            // Recursively sort each half
            ListNode left = sortList(head);
            ListNode right = sortList(nextOfMiddle);

            // Merge the two sorted halves
            return merge(left, right);
        }

        // Helper function to get the middle node of a list
        private static ListNode getMiddle(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode fast = head.next;
            ListNode slow = head;

            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            return slow;
        }

        // Helper function to merge two sorted lists
        private static ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    current.next = left;
                    left = left.next;
                } else {
                    current.next = right;
                    right = right.next;
                }
                current = current.next;
            }

            if (left != null) {
                current.next = left;
            }

            if (right != null) {
                current.next = right;
            }

            return dummy.next;
        }
    }


