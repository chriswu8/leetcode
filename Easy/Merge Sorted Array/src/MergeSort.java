// Merge sort in Java

class MergeSort
{
    public void mergeSort(int[] arr)
    {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSort(int[] arr,
                           int[] temp,
                           final int leftStart,
                           final int rightEnd)
    {
        if(leftStart >= rightEnd)
        {
            return;
        }

        int m = (leftStart + rightEnd) / 2;

        mergeSort(arr, temp, leftStart, m);

        mergeSort(arr, temp, m + 1, rightEnd);

        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    private void mergeHalves(int[] arr,
                             int[] temp,
                             final int leftStart,
                             final int rightEnd)
    {
        int leftEnd;
        int rightStart;
        int leftPointer;
        int rightPointer;
        int index;
        int size;

        leftEnd = (rightEnd + leftStart) / 2;
        rightStart = leftEnd + 1;
        leftPointer = leftStart;
        rightPointer = rightStart;
        index = leftStart;
        size = rightEnd - leftStart + 1; // ***

        while(leftPointer <= leftEnd && rightPointer <= rightEnd)
        {
            if(arr[leftPointer] <= arr[rightPointer])
            {
                temp[index] = arr[leftPointer];
                leftPointer++;
            }
            else
            {
                temp[index] = arr[rightPointer];
                rightPointer++;
            }
            index++;
        }

        if(leftPointer > leftEnd)
        {
            System.arraycopy(arr, rightPointer, temp, index, rightEnd - rightPointer + 1);
        }

        if(rightPointer > rightEnd)
        {
            System.arraycopy(arr, leftPointer, temp, index, leftEnd - leftPointer + 1);
        }
        System.arraycopy(temp, leftStart, arr, leftStart, size);
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
        int[] arr = {4, 3, 2, 1};

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}