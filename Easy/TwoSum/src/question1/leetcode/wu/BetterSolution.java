package question1.leetcode.wu;

import java.util.HashMap;
import java.util.Map;

public class BetterSolution
{
    private static final int SIZE = 2;

    // Time complexity: O(n), Space complexity: O(n)
    public int[] twoSum(final int[] nums,
                        final int target)
    {
        int                   complement;
        Map<Integer, Integer> map;

        map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++)
        {
            complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i)
            {
                return new int[]{i, map.get(complement)};
            }
        } return null;
    }


    public static void main(String[] args)
    {
        int[]  nums;
        int[]  returnedArray;
        TwoSum obj;

        nums = new int[]{2, 7, 11, 15};
        obj = new TwoSum();

        returnedArray = obj.twoSum(nums, 9);
        System.out.println("[" + returnedArray[0] + ", " + returnedArray[1] + "]");
    }
}
