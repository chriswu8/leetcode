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
                                       int l,
                                       int r)
    {
        if(l == r) // if the String[] only has one element (base case)
        {
            return strs[l]; // return that one element
        }
        else
        {
            int    mid      = (l + r) / 2;
            String lcpLeft  = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
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
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args)
    {
        String[]  strArray = new String[]{"ab", "a"};
        Solution3 obj      = new Solution3();
        System.out.println(obj.longestCommonPrefix(strArray));
    }
}
