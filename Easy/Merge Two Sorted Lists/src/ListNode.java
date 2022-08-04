public class ListNode
{
    int      val;
    char     data;
    ListNode next;


    ListNode(int val)
    {

        this.val = val;
    }
    ListNode(char data)
    {

        this.data = data;
    }

    ListNode(int val,
             ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    ListNode(char data,
             ListNode next)
    {
        this.data = data;
        this.next = next;
    }
}
