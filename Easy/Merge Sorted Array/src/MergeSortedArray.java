public class MergeSortedArray
{
    public void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n)
    {
        for(int i = m, j=0; i < nums1.length; i++, j++)
        {
            nums1[i] = nums2[j];
        }


    }

    public static void main(final String[] args)
    {
        MergeSortedArray obj;
        int[]            arr1;
        int[]            arr2;

        obj = new MergeSortedArray();

        arr1 = new int[9];
        arr2 = new int[]{12, 5, 6};

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 0;
        arr1[4] = 0;
        arr1[5] = 0;

        obj.merge(arr1, 3, arr2, 3);

        for(int i : arr1)
        {
            System.out.println(i + " ");
        }

    }
}
