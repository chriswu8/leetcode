/*
Not functional according to requirements.
 */
public class MergeSortedArray
{

    private static MergeSortedArray obj;
    private static int[]            arr1;
    private static int[]            arr2;

    /**
     * @param nums1 is the first array
     * @param m     number of elements in nums1
     * @param nums2 is the second array
     * @param n     number of elements in nums2
     */
    public void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n)
    {
        MergeSort obj;
        int       nums1Index;
        int       nums1Pointer;
        int       nums2Pointer;

        obj = new MergeSort();
        nums1Index = 0;

        while(nums1[nums1Index] != 0)
        {
            nums1Index++;
        }

        if(nums1Index != - 1)
        {
            nums1Pointer = nums1Index;
            nums2Pointer = 0;

            while(nums1Pointer < m)
            {
                nums1[nums1Pointer] = nums2[nums2Pointer];
                nums1Pointer++;
                nums2Pointer++;
            }
            obj.mergeSort(nums1);
            if(nums1[0] == 0)
            {
                int i = 0;
                while(nums1[i] == 0)
                {
                    i++;
                }

                int[] temp = new int[m + n - i];

                System.arraycopy(nums1, i, temp, 0, m + n - i);
                arr1 = temp;
            }
        }
        else
        {
            if(m == 0)
            {
                return;
            }

            if(n == 0)
            {
                obj.mergeSort(nums1);
            }
        }
    }

    public static void main(final String[] args)
    {
        obj = new MergeSortedArray();
        arr1 = new int[9];
        arr2 = new int[]{2, 5, 6};

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 0;
        arr1[4] = 0;
        arr1[5] = 0;

        obj.merge(arr1, 6, arr2, 3);

        for(int i : arr1)
        {
            System.out.print(i + " ");
        }
    }
}
