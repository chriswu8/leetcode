public class PlusOne
{
    public int[] plusOne(final int[] digits)
    {
        int   last;
        int   leftPointer;
        int[] newArr;

        last = digits.length - 1;
        leftPointer = last - 1;

        if(digits[last] != 9)
        {
            digits[last]++;
            return digits;
        }

        while(leftPointer >= 0)
        {
            if(digits[leftPointer] != 9)
            {
                digits[leftPointer]++;
                for(int i = leftPointer + 1; i < digits.length; i++)
                {
                    digits[i] = 0;
                }
                return digits;
            }
            leftPointer--;
        }

        return handleAll9s(digits);
    }

    private int[] handleAll9s(final int[] digits)
    {
        int[] newArr;
        newArr = new int[digits.length + 1];
        newArr[0] = 1;
        return newArr;
    }


    public static void main(String[] args)
    {
        PlusOne obj;
        int[]   arr;

        obj = new PlusOne();
        arr = new int[]{ 9,9,9,9,9, 9, 9};

        for(int i : obj.plusOne(arr))
        {
            System.out.println(i);
        }
    }
}
