import java.util.ArrayList;
import java.util.List;

/**
 * Recursive approach
 */
public class BinaryTreeInorderTraversal
{
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return result;
        }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }


    public static void main(String[] args)
    {
        TreeNode first  = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third  = new TreeNode(3);

        first.right = second;
        second.left = third;

        BinaryTreeInorderTraversal obj  = new BinaryTreeInorderTraversal();
        List<Integer>              list = obj.inorderTraversal(first);

        for(Integer i : list)
        {
            System.out.print(i + " ");
        }
    }
}
