public class Solution2
{
    public int strStr(final String haystack,
                      final String needle)
    {
        char[] haystackArr     = haystack.toCharArray();
        char[] needleArr       = needle.toCharArray();
        int    haystackPointer = 0;
        int    needlePointer   = 0;

        while(haystackPointer < haystackArr.length)
        {
            if(haystackArr[haystackPointer] == needleArr[needlePointer])
            {
                needlePointer++;
            }
            else
            {
                // if not equal, set haystack to the position of first character match
                haystackPointer -= needlePointer;
                // then reset the needle pointer
                needlePointer = 0;
            }

            haystackPointer++;

            if(needlePointer == needleArr.length)
            {
                return haystackPointer - needlePointer;
            }
        }
        return - 1;
    }

    public static void main(final String[] args)
    {
        Solution2 obj = new Solution2();
        System.out.println(obj.strStr("hello", "ll"));  // should output 2
        System.out.println(obj.strStr("aaaaa", "bba")); // should output -1
        System.out.println(obj.strStr("a", "a")); // should output 0
        System.out.println(obj.strStr("abc", "c")); // should output 2
        System.out.println(obj.strStr("aaa", "a")); // should output 0
        System.out.println(obj.strStr("mississippi", "a")); // should output -1
    }
}
