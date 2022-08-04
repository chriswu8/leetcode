public class Node
{
    String data;
    Node   next;

    public Node(final String data)
    {
        this.data = data;
    }

    public Node(final String data,
                Node next)
    {
        this.data = data;
        this.next = next;
    }
}
