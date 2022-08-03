import java.util.HashMap;
import java.util.Stack;

public class AlgoIoSolution
{

    public boolean contains(final char c,
                            final char[] array)
    {
        for(char x : array)
        {
            if(x == c)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isValid(final String s)
    {
        String                        openingBrackets  = "([{";
        String                        closingBrackets  = ")]}";
        HashMap<Character, Character> matchingBrackets = new HashMap();
        Stack<Character>              stack            = new Stack<Character>();

        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');

        for(char c : s.toCharArray())
        {
            if(contains(c, openingBrackets.toCharArray()))
            {
                stack.push(c);
            }
            else if(contains(c, closingBrackets.toCharArray()))
            {
                if(stack.size() == 0)
                {
                    return false;
                }

                if(stack.lastElement() == matchingBrackets.get(c))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(final String[] args)
    {
        AlgoIoSolution obj;
        obj = new AlgoIoSolution();

        System.out.println(obj.isValid("[([]])"));
        System.out.println(obj.isValid("()"));
    }
}
