package question1.leetcode.wu;

/**
 * Chris Wu's solution to the TwoSum LeetCode question.
 * @author Chris Wu
 * @version 1.0
 */
public class TwoSum
{
    private static final int SIZE = 2;
    private static final int ZERO = 0;
    private static final int ONE  = 1;


    // Time complexity: O(n^2), Space complexity: O(1)
    public int[] twoSum(final int[] nums,
                        final int target)
    {
        int[] indices;
        indices = new int[SIZE];

        for(int i = ZERO; i < nums.length - ONE; i++)
        {
            for(int j = i + ONE; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    indices[ZERO] = i;
                    indices[ONE] = j;
                    return indices;
                }
            }
        }
        return indices;
    }


    public static void main(String[] args)
    {
        int[]  nums;
        int[]  returnedArray;
        TwoSum obj;

        nums = new int[]{2, 7, 11, 15};
        obj = new TwoSum();
        returnedArray = new int[SIZE];

        returnedArray = obj.twoSum(nums, 9);
        System.out.println(returnedArray[0]);
        System.out.println(returnedArray[1]);

    }
}
