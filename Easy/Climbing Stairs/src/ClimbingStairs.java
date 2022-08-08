public class ClimbingStairs
{
    public int climbStairs(final int n)
    {
        int oneBefore;
        int twoBefore;
        int runningSum;

        twoBefore = 1;
        oneBefore = 2;
        runningSum = 0;

        if(n == 1 || n == 2)
        {
            return n;
        }

        for(int i = 2; i < n; i++)
        {
            runningSum = oneBefore + twoBefore;
            twoBefore = oneBefore;
            oneBefore = runningSum;
        }
        return runningSum;
    }

    public static void main(final String[] args)
    {
        ClimbingStairs obj;
        obj = new ClimbingStairs();

        System.out.println(obj.climbStairs(1)); // 1
        System.out.println(obj.climbStairs(2)); // 2
        System.out.println(obj.climbStairs(3)); // 3
        System.out.println(obj.climbStairs(4)); // 5
        System.out.println(obj.climbStairs(5)); // 8
        System.out.println(obj.climbStairs(6)); // 13
        System.out.println(obj.climbStairs(37)); //
    }
}
