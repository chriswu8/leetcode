class Solution
{

    public ListNode mergeTwoLists(ListNode l1,
                                  ListNode l2)
    {
        if(l1 == null) // base case
        {
            return l2;
        }
        if(l2 == null) // base case
        {
            return l1;
        }

        if(l1.val <= l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //display() will display all the nodes present in the list
    public void display(ListNode list)
    {
        if(list == null)
        {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of singly linked list: ");

        while(list != null)
        {
            //Prints each node by incrementing pointer
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(10, new ListNode(20, new ListNode(30)));
        ListNode list3;

        Solution solution = new Solution();

        list3 = solution.mergeTwoLists(list1, list2);
        solution.display(list3);
    }
}