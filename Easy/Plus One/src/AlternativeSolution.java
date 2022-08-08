public class AlternativeSolution
{
    public int[] plusOne(int[] digits)
    {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--)
        {
            if(digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }


    public static void main(String[] args)
    {
        AlternativeSolution obj;
        int[]   arr;

        obj = new AlternativeSolution();
        arr = new int[]{ 9, 9, 9};

        for(int i : obj.plusOne(arr))
        {
            System.out.println(i);
        }
    }
}
