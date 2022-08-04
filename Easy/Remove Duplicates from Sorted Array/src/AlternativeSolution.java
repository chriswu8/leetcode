/**
 * Takes less space
 */
public class AlternativeSolution
{
    int removeDuplicates(int A[])
    {
        int n = A.length;
        if(n < 2)
        {
            return n;
        }
        int id = 1;
        for(int i = 1; i < n; ++ i)
            if(A[i] != A[i - 1])
            {
                A[id++] = A[i];
            }
        return id;
    }


    public static void main(String[] args)
    {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        System.out.println(obj.removeDuplicates(new int[]{1, 1, 2, 999}));
    }
}
