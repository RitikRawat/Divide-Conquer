class InversionPair
{
    static int inverse(int a[], int l, int h)
    {
     if(l<h)
     {
         int m= (l+h)/2 ;
         int n =0;
         n+=inverse(a,l,m);
         n+=inverse(a,m+1,h);
         n+=calculate(a,l,m,h);

         return  n;
     }
     else
     {return 0;}

    }

    private static int calculate(int[] a,int l,int m, int h)
    {
        int n =0;
        int f= m-l+1;
        int s= h-m;

        int[] F = new int[f];
        int[] S = new int[s];

        System.arraycopy(a,l,F,0,f);
        System.arraycopy(a,m+1,S,0,s);

        int i=0,j=0,k=l;

        while(i<f && j<s)
        {
            if(F[i]<=S[j])
            {
                a[k] = F[i];
                i++;
            }
            else
            {
                a[k] = S[j];

                n+= (f-i) ;
                j++;
            }

            k++;
        }
        while(i<f)
        {
            a[k] = F[i];
            i++;
                    k++;
        }

        while(j<s)
        {
            a[k] = S[j];
            j++;
                    k++;

        }

        return n;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,5,4,6,7,3,2};
        int n = inverse(arr,0,6);
        System.out.println(n);
    }
}