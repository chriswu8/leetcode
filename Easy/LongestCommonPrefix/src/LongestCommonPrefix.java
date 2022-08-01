import java.util.ArrayList;
import java.util.List;

/*
SOLUTION NOT ENTIRELY CORRECT... FAILING ["flower","flower","flower","flower"] TEST ON LEETCODE...
 */

public class LongestCommonPrefix
{
    public String longestCommonPrefix(final String[] strs)
    {
        List<Character> list;
        char[]          arr;
        boolean         appendChar;
        boolean         allElementsSame;

        list = new ArrayList<>();
        arr = new char[200];
        appendChar = true;
        allElementsSame = true;

        if(strs.length < 1)
        {
            return "";
        }

        for(String str : strs)
        {
            if(str.length() < 2)
            {
                return str;
            }
        }

        for(int i = 1; i < strs.length; i++)
        {
            if(strs[i] != strs[i - 1])
            {
                allElementsSame = false;
            }
        }

        if(allElementsSame)
        {
            return strs[0];
        }

        for(int i = 0; i < strs.length; i++)      // iterates over String[] strs
        {
            // iterate over each character at a specific index of each string
            for(String str : strs)
            {
                list.add(str.charAt(i));
            }

            for(int j = 1; j < list.size(); j++)   // iterate over arraylist to check common prefix
            {
                if(list.get(j) != list.get(j - 1)) // checks if not all the same letter
                {
                    list.clear();
                    appendChar = false;
                    break;
                }
            }

            if(appendChar)
            {
                arr[i] = list.get(i);
                list.clear();
            }
        }
        return String.valueOf(arr).trim();
    }

    public static void main(final String[] args)
    {
        String[]            strArray = new String[]{"flower", "flower", "flower", "flower"};
        LongestCommonPrefix obj      = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(strArray));
    }
}
