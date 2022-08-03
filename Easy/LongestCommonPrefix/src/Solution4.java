public class Solution4
{
    public String longestCommonPrefix(String[] strs)
    {
        int minLen;
        int low;
        int high;

        minLen = Integer.MAX_VALUE;

        if(strs == null || strs.length == 0)
        {
            return "";
        }

        for(String str : strs)
        {
            minLen = Math.min(minLen, str.length());
        }

        low = 1;
        high = minLen;

        while(low <= high)
        {
            int middle = (low + high) / 2;
            if(isCommonPrefix(strs, middle))
            {
                low = middle + 1;
            }
            else
            {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs,
                                   int len)
    {
        String str1 = strs[0].substring(0, len);

        for(int i = 1; i < strs.length; i++)
            if(! strs[i].startsWith(str1))
            {
                return false;
            }
        return true;
    }

    public static void main(String[] args)
    {
        String[]  strArray = new String[]{"ab", "a"};
        Solution4 obj      = new Solution4();
        System.out.println(obj.longestCommonPrefix(strArray));
    }
}
