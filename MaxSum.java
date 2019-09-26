public class MaxSum
{
    private static int MaxSumSub(int[] A,int l,int h)
    {
        if(l==h)
        {
            return A[l];
        }

        int m =(l+h)/2;

        int max = Math.max(Math.max(MaxSumSub(A,l,m),MaxSumSub(A,m+1,h)),CrossSum(A,l,m,h));
        return max;
    }

    private static int CrossSum(int[] A, int l, int m, int h)
    {
        int sum =0;
        int ls = Integer.MIN_VALUE;

        for(int i=m;i>=l;i--)
        {
            sum+=A[i];
            if(sum>ls)
                ls = sum;

        }

        sum =0;
        int rs = Integer.MIN_VALUE;

        for(int i =m+1;i<=h;i++)
        {
            sum+=A[i];
            if(sum>rs)
                rs = sum;

        }

        return ls+rs;
    }

    public static int MaxSumSubArray(int[] A)
    {
        return MaxSumSub(A,0,A.length-1);
    }

    
}
