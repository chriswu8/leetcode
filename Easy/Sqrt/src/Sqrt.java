public class Sqrt
{
    public int mySqrt(final int x)
    {
        int     left;
        int     right;
        int     mid;
        boolean leftMidSame;
        boolean xDivMidEqualsMid;
        boolean leftHalf;

        left = 2;
        right = x;
        leftMidSame = false;
        xDivMidEqualsMid = false;

        if(x == 0 || x == 1)
        {
            return x;
        }

        if(x / left == 1)
        {
            return 1;
        }

        while(! (leftMidSame || xDivMidEqualsMid))
        {
            mid = (left + right) / 2;
            // used to prevent overflow when multiplying big numbers
            xDivMidEqualsMid = x / mid == mid;
            leftHalf = (x / mid < mid);
            leftMidSame = left == mid;

            if(xDivMidEqualsMid || leftMidSame)
            {
                xDivMidEqualsMid = true;
                return mid;
            }

            if(leftHalf)
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        return - 1;
    }

    public static void main(String[] args)
    {
        Sqrt obj;

        obj = new Sqrt();

        System.out.println(obj.mySqrt(2)); // 1
        System.out.println(obj.mySqrt(3)); // 1
        System.out.println(obj.mySqrt(5)); // 2
        System.out.println(obj.mySqrt(120)); // 10
        System.out.println(obj.mySqrt(121)); // 11
        System.out.println(obj.mySqrt(2147395599)); // 46339
    }
}
