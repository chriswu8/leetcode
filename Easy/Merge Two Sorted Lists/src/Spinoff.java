/**
 * Comparing Strings this time
 */
public class Spinoff
{
    public Node mergeSortedString(Node n1,
                                  Node n2)
    {
        if(n1 == null)
        {
            return n2;
        }

        if(n2 == null)
        {
            return n1;
        }

        if(n1.data.compareTo(n2.data) < 0)
        {
            n1.next = mergeSortedString(n1.next, n2);
            return n1;
        }
        else
        {
            n2.next = mergeSortedString(n1, n2.next);
            return n2;
        }
    }

    public void display(Node node)
    {
        if(node == null)
        {
            System.out.println("Empty list");
        }

        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args)
    {
        Spinoff obj;
        String  str1;
        String  str2;
        String  str3;
        String  str4;
        String  str5;
        String  str6;
        Node    node1;
        Node    node2;
        Node    node3;
        Node    node4;
        Node    node5;
        Node    node6;

        obj = new Spinoff();
        str1 = "aaa";
        str2 = "bbb";
        str3 = "ccc";
        str4 = "ddd";
        str5 = "eee";
        str6 = "fff";
        node1 = new Node(str1);
        node2 = new Node(str3);
        node3 = new Node(str5);
        node4 = new Node(str2);
        node5 = new Node(str4);
        node6 = new Node(str6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        obj.display(obj.mergeSortedString(node1, node4));
    }
}

