/**
 * Time complexity : O(S), where S is the sum of all characters in all strings.
 *
 * In the worst case all n strings are the same.
 * There are S character comparisons, where S is the sum of all characters in the input array.
 *
 * Space complexity : O(1).
 */

public class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        if(strs.length == 0)
        {
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) // iterate String[] starting @ the second string
        {
            System.out.println("looping!!!!!");

            while(strs[i].indexOf(prefix) != 0)  // true if the prefix string does not start at index 0
            {
                System.out.println("prefix: " + prefix);

                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty())
                {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(final String[] args)
    {
        String[] strArray = new String[]{"leets", "leetcode", "leet", "leeds"};
        Solution obj      = new Solution();
        System.out.println("\n\n" + obj.longestCommonPrefix(strArray));

    }
}
