class Solution
{
    public int strStr(final String haystack,
                      final String needle)
    {
        String chunk;

        if(! haystack.contains(needle))
        {
            return - 1;
        }
        else
        {
            for(int i = 0; i < haystack.length(); i++)
            {
                chunk = haystack.substring(i, i + needle.length());

                if(chunk.equals(needle))
                {
                    return i;
                }
            }
        }
        return - 1;
    }

    public static void main(final String[] args)
    {
        Solution obj = new Solution();
        System.out.println(obj.strStr("hello", "ll"));  // should output 2
        System.out.println(obj.strStr("aaaaa", "bba")); // should output -1
        System.out.println(obj.strStr("a", "a")); // should output 0
        System.out.println(obj.strStr("abc", "c")); // should output 2
        System.out.println(obj.strStr("aaa", "a")); // should output 0
        System.out.println(obj.strStr("mississippi", "a")); // should output -1
    }
}