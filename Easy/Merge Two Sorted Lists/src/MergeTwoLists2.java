import java.util.List;

public class MergeTwoLists2
{
    public ListNode mergeTwoLists(ListNode l1,
                                  ListNode l2)
    {
        if(l1 == null)
        {
            return l2;
        }

        if(l2 == null)
        {
            return l1;
        }

        if(l1.data <= l2.data)
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

    public void display(ListNode list)
    {
        if(list == null)
        {
            System.out.println("List is empty");
            return;
        }

        while(list != null)
        {
            System.out.print(list.data + "\t");
            list = list.next;
        }
    }

    public static void main(String[] args)
    {
        MergeTwoLists2 obj = new MergeTwoLists2();

        ListNode list1 = new ListNode('a', new ListNode('c', new ListNode('f')));
        ListNode list2 = new ListNode('b', new ListNode('d', new ListNode('e')));

        obj.display(obj.mergeTwoLists(list1, list2));
    }
}
