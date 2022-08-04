public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates(int[] nums)
    {
        int left;
        int right;

        left = 0;
        right = 1;

        if(nums.length < 2)
        {
            return nums.length;
        }

        while(right < nums.length)
        {
            if(nums[left] != nums[right])
            {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return ++left;
    }

    public static void main(String[] args)
    {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        System.out.println(obj.removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10, 999}));
    }
}
