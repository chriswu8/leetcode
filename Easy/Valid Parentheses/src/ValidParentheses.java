import java.util.ArrayList;
import java.util.List;

public class ValidParentheses
{
    private final char[] validParentheses;
    private final char[] closingParentheses;
    private int previousConsecutiveClosing;

    public ValidParentheses()
    {
        validParentheses   = new char[]{'(', ')', '[', ']', '{', '}'};
        closingParentheses = new char[]{')',  ']', '}'};
    }

    public boolean isValid(final String s)
    {
        boolean validString;
        boolean validOrder;
        char[]  charactersInString;

        charactersInString = s.toCharArray();
        validString = checkString(charactersInString); // check to see if even # characters and whether only parentheses
        validOrder = false;

        if(validString)
        {
            if(checkMoreRightThanLeft(charactersInString))
            {
                return false;
            }
            validOrder = checkParenthesesOrder(charactersInString);
        }
        return validOrder;
    }

    private boolean checkMoreRightThanLeft(final char[] charactersInString)
    {
        int rightRound;
        int rightSquare;
        int rightCurly;
        int leftRound;
        int leftSquare;
        int leftCurly;

        rightRound = 0;
        rightSquare = 0;
        rightCurly = 0;
        leftRound = 0;
        leftSquare = 0;
        leftCurly = 0;

        for(char c : charactersInString)
        {
            if(c == '(')
            {
                leftRound++;
            }

            if(c == ')')
            {
                rightRound++;
            }

            if(c == '[')
            {
                leftSquare++;
            }

            if(c == ']')
            {
                rightSquare++;

            }

            if(c == '{')
            {
                leftCurly++;
            }

            if(c == '}')
            {
                rightCurly++;
            }

            if(rightRound > leftRound || rightSquare > leftSquare || rightCurly > leftCurly)
            {
                return true;
            }
        }
        return false;
    }

    private boolean moreDifferentRight(final int rightRound,
                                       final int rightSquare,
                                       final int rightCurly,
                                       final int leftRound,
                                       final int leftSquare,
                                       final int leftCurly)
    {
        return leftRound < rightSquare || leftRound < rightCurly || leftSquare < rightRound || leftSquare < rightCurly || leftCurly < rightSquare || leftCurly < rightRound;
    }

    private boolean checkParenthesesOrder(final char[] charactersInString)
    {
        boolean sameLeftRightRound;
        boolean sameLeftRightSquare;
        boolean sameLeftRightCurly;

        sameLeftRightRound  = matchingNumOfRound(charactersInString);
        sameLeftRightSquare = matchingNumOfSquare(charactersInString);
        sameLeftRightCurly  = matchingNumOfCurly(charactersInString);

        return sameLeftRightRound                  &&
                sameLeftRightSquare                &&
                sameLeftRightCurly                 &&
                correctOpening(charactersInString) ||
                correctClosing(charactersInString);
    }

    private boolean correctClosing(final char[] charactersInString)
    {
        return  correctRightRound(charactersInString)  &&
                correctRightSquare(charactersInString) &&
                correctRightCurly(charactersInString);
    }

    private boolean correctRightCurly(final char[] charactersInString)
    {
        int leftShift;

        previousConsecutiveClosing = 0;

        for(int i = 1 ; i < charactersInString.length; i++)
        {
            if(contains(charactersInString[i], closingParentheses))
            {
                previousConsecutiveClosing++;
                leftShift = 2 * previousConsecutiveClosing - 1;

                if(charactersInString[i] == '}')
                {
                    return charactersInString[i-leftShift] == '{';
                }
            }
        }
        return false;
    }

    private boolean correctRightSquare(final char[] charactersInString)
    {
        int leftShift;

        previousConsecutiveClosing = 0;

        for(int i = 1 ; i < charactersInString.length; i++)
        {
            if(contains(charactersInString[i], closingParentheses))
            {
                previousConsecutiveClosing++;
                leftShift = 2 * previousConsecutiveClosing - 1;

                if(charactersInString[i] == ']')
                {
                    return charactersInString[i-leftShift] == '[';
                }
            }
        }
        return false;
    }

    private boolean correctRightRound(final char[] charactersInString)
    {
        int leftShift;

        previousConsecutiveClosing = 0;

        for(int i = 1 ; i < charactersInString.length; i++)
        {
            if(contains(charactersInString[i], closingParentheses))
            {
                previousConsecutiveClosing++;
                leftShift = 2 * previousConsecutiveClosing - 1;

                if(charactersInString[i] == ')')
                {
                    return charactersInString[i-leftShift] == '(';
                }
            }
        }
        return false;
    }

    private boolean correctOpening(final char[] charactersInString)
    {
        return  dealWithRound(charactersInString) &&
                dealWithSquare(charactersInString) &&
                dealWithCurly(charactersInString);
    }

    private boolean dealWithCurly(final char[] charactersInString)
    {
        for(int i = 0; i < charactersInString.length - 1; i++)
        {
            if(charactersInString[i] == '{' && charactersInString[i + 1] != '}')
            {
                if(charactersInString[i + 1] != '(' &&
                        charactersInString[i + 1] != '[' &&
                        charactersInString[i + 1] != '{')
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dealWithSquare(final char[] charactersInString)
    {
        for(int i = 0; i < charactersInString.length - 1; i++)
        {
            if(charactersInString[i] == '[' && charactersInString[i + 1] != ']')
            {
                if(charactersInString[i + 1] != '(' &&
                        charactersInString[i + 1] != '[' &&
                        charactersInString[i + 1] != '{')
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dealWithRound(final char[] charactersInString)
    {
        for(int i = 0; i < charactersInString.length - 1; i++)
        {
            if(charactersInString[i] == '(' && charactersInString[i + 1] != ')')
            {
                if(charactersInString[i + 1] != '(' &&
                        charactersInString[i + 1] != '[' &&
                        charactersInString[i + 1] != '{')
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean matchingNumOfCurly(final char[] charactersInString)
    {
        int numOfLeft;
        int numOfRight;

        numOfLeft = 0;
        numOfRight = 0;

        for(char c : charactersInString)
        {
            if(c == '{')
            {
                numOfLeft++;
            }
            if(c == '}')
            {
                numOfRight++;
            }
        }
        return numOfLeft == numOfRight;
    }

    private boolean matchingNumOfSquare(final char[] charactersInString)
    {
        int numOfLeft;
        int numOfRight;

        numOfLeft = 0;
        numOfRight = 0;

        for(char c : charactersInString)
        {
            if(c == '[')
            {
                numOfLeft++;
            }
            if(c == ']')
            {
                numOfRight++;
            }
        }
        return numOfLeft == numOfRight;
    }

    private boolean matchingNumOfRound(final char[] charactersInString)
    {
        int numOfLeft;
        int numOfRight;

        numOfLeft = 0;
        numOfRight = 0;

        for(char c : charactersInString)
        {
            if(c == '(')
            {
                numOfLeft++;
            }
            if(c == ')')
            {
                numOfRight++;
            }
        }
        return numOfLeft == numOfRight;
    }

    private boolean checkString(final char[] arr)
    {
        int count;

        if(arr.length % 2 == 1) // takes care of odd number strings
        {
            return false;
        }

        for(char c : arr)
        {
            count = 0;

            for(char ch : validParentheses)
            {
                if(c != ch)
                {
                    count++;
                }
            }
            if(count == 6)
            {
                return false;
            }
        }
        return true;
    }

    public boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args)
    {
        ValidParentheses obj;
        obj = new ValidParentheses();

        System.out.println(obj.isValid("[([]])"));
        System.out.println(obj.isValid("()"));
    }
}
