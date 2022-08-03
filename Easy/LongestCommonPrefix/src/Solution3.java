/*
In the worst case we have n equal strings with length m

Time complexity : O(S*log m), where S is the sum of all characters in all strings.

The algorithm makes log(m) iterations, for each of them there are S=m⋅n comparisons, which gives in total
O(S⋅logm) time complexity.

Space complexity : O(1)
 */

public class Solution3
{
    public String longestCommonPrefix(String[] strs)
    {
        if(strs == null || strs.length == 0)
        {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs,
                                       int leftMostIndex,
                                       int rightMostIndex)
    {
        if(leftMostIndex == rightMostIndex) // if the String[] only has one element (base case)
        {
            return strs[leftMostIndex]; // return that one element
        }
        else
        {
            int    mid      = (leftMostIndex + rightMostIndex) / 2;
            String lcpLeft  = longestCommonPrefix(strs, leftMostIndex, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, rightMostIndex);

            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,
                        String right)
    {
        int min = Math.min(left.length(), right.length());

        for(int i = 0; i < min; i++)
        {
            if(left.charAt(i) != right.charAt(i))
            {
                // return up to the previous matching character
                return right.substring(0, i);
            }
        }
        // return the shorter string
        return right.substring(0, min);
    }

    public static void main(String[] args)
    {
        String[]  strArray = new String[]{"ab", "a"};
        Solution3 obj      = new Solution3();
        System.out.println(obj.longestCommonPrefix(strArray));
    }
}
