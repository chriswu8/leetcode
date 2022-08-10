// Merge sort in Java

class MergeSort
{
    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(final int[] arr,
                   final int l,
                   final int r)
    {
        if(l < r)
        {
            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            // merge sort left subarray
            mergeSort(arr, l, m);

            // merge sort right subarray
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays L and M into arr
    void merge(final int[] arr,
               final int left,
               final int middle,
               final int right)
    {
        int   leftArrSize;
        int   rightArrSize;
        int   i;
        int   j;
        int   k;
        int[] leftSubArray;
        int[] rightSubArray;

        leftArrSize = middle - left + 1;
        rightArrSize = right - middle;

        leftSubArray = new int[leftArrSize];
        rightSubArray = new int[rightArrSize];

        populateSubArrays(arr, left, middle, leftArrSize, rightArrSize, leftSubArray, rightSubArray);

        // Maintain current index of sub-arrays and main array
        i = 0;
        j = 0;
        k = left;

        // Place larger elements in the correct positions (till we reach either end of the subarrays)
        while(i < leftArrSize && j < rightArrSize)
        {
            if(leftSubArray[i] <= rightSubArray[j])
            {
                arr[k] = leftSubArray[i];
                i++;
            }
            else
            {
                arr[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while(i < leftArrSize)
        {
            arr[k] = leftSubArray[i];
            i++;
            k++;
        }

        while(j < rightArrSize)
        {
            arr[k] = rightSubArray[j];
            j++;
            k++;
        }
    }

    private void populateSubArrays(final int[] arr,
                                   final int left,
                                   final int middle,
                                   final int leftArrSize,
                                   final int rightArrSize,
                                   final int[] leftSubArray,
                                   final int[] rightSubArray)
    {
        for(int i = 0; i < leftArrSize; i++)
        {
            leftSubArray[i] = arr[left + i];
        }

        for(int j = 0; j < rightArrSize; j++)
        {
            rightSubArray[j] = arr[middle + 1 + j];
        }
    }


    // Print the array
    static void printArray(final int[] arr)
    {
        for(int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    // Driver program
    public static void main(final String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}