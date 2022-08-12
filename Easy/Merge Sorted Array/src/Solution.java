public class Solution
{
    public void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n)
    {
        int p1;
        int p2;
        int i;

        p1 = m - 1;
        p2 = n - 1;
        i = m + n - 1;

        while(p2 >= 0)
        {
            if(p1 >= 0 && nums1[p1] >= nums2[p2])
            {
                nums1[i] = nums1[p1];
                i--;
                p1--;
            }
            else
            {
                nums1[i] = nums2[p2];
                i--;
                p2--;
            }
        }
    }

    public static void main(String[] args)
    {
        Solution obj   = new Solution();
        int[]    nums1 = {2, 2, 2, 0, 0};
        int[]    nums2 = {1, 3};
        obj.merge(nums1, 3, nums2, 2);
        for(int i : nums1)
        {
            System.out.println(i);
        }
    }
}
