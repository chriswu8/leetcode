package question13.leetcode.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * Chris Wu's solution to the Roman to Integer LeetCode question.
 * @author Chris Wu
 * @version 1.0
 */
public class RomanToInteger
{
    private static int                     runningSum;
    private static Map<Character, Integer> map;
    private static char[]                  romanLetters;

    /**
     * The RomanToInteger constructor.
     */
    public RomanToInteger()
    {
        map = new HashMap();
        populateMap();
    }


    public int romanToInt(final String s)
    {
        runningSum = 0;
        romanLetters = s.toCharArray();

        if(romanLetters.length == 1)
        {
            return map.get(romanLetters[0]);
        }

        for(int i = 0; i < romanLetters.length - 1; i++)
        {
            if(romanLetters[i] == 'I')
            {
                i = processI(i);
            }
            else if(romanLetters[i] == 'X')
            {
                i = processX(i);
            }
            else if(romanLetters[i] == 'C')
            {
                i = processC(i);
            }
            else
            {
                runningSum += map.get(romanLetters[i]);
            }
        }

        if(! (romanLetters[romanLetters.length - 2] == 'I' && romanLetters[romanLetters.length - 1] == 'V') &&
                ! (romanLetters[romanLetters.length - 2] == 'I' && romanLetters[romanLetters.length - 1] == 'X') &&
                ! (romanLetters[romanLetters.length - 2] == 'X' && romanLetters[romanLetters.length - 1] == 'L') &&
                ! (romanLetters[romanLetters.length - 2] == 'X' && romanLetters[romanLetters.length - 1] == 'C') &&
                ! (romanLetters[romanLetters.length - 2] == 'C' && romanLetters[romanLetters.length - 1] == 'D') &&
                ! (romanLetters[romanLetters.length - 2] == 'C' && romanLetters[romanLetters.length - 1] == 'M'))
        {
            runningSum += map.get(romanLetters[romanLetters.length - 1]);
        }
        return runningSum;
    }

    private int processC(int i)
    {
        if(romanLetters[i + 1] == 'D')
        {
            runningSum += 400;
            i++;
        }
        else if(romanLetters[i + 1] == 'M')
        {
            runningSum += 900;
            i++;
        }
        else
        {
            runningSum += map.get('C');
        }
        return i;
    }

    private int processX(int i)
    {
        if(romanLetters[i + 1] == 'L')
        {
            runningSum += 40;
            i++;
        }
        else if(romanLetters[i + 1] == 'C')
        {
            runningSum += 90;
            i++;
        }
        else
        {
            runningSum += map.get('X');
        }
        return i;
    }


    private int processI(int i)
    {
        if(romanLetters[i + 1] == 'V')
        {
            runningSum += 4;
            i++;
        }
        else if(romanLetters[i + 1] == 'X')
        {
            runningSum += 9;
            i++;
        }
        else
        {
            runningSum++;
        }
        return i;
    }

    private void populateMap()
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(final String[] args)
    {
        RomanToInteger obj;

        obj = new RomanToInteger();

        System.out.println(obj.romanToInt("III"));
    }
}
