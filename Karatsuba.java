public class Karastsuba
{
    static String[] divide(String a)
    {
        a.trim();
        int l = a.length();
        String r[] = new String[][2];
        if(l>1) {
            String al = a.substring(0, l / 2);
            String ar = a.substring(l / 2, l);
            //System.out.println(al + "   " + ar);


            r[0] = al;
            r[1] = ar;

            //System.out.println(r[0] + "   " + r[1]);
                }
        else
        {
            r[0] = "0";
            r[1] = a;
        }

        return r;
    }

    static int getLength(long num)
    {
        int ctr = 0;
        while (num != 0)
        {
            ctr++;
            num /= 10;
        }
        return ctr;
    }

    static String multiply(String a,String b)
    {
        int N = Math.max(a.length(),b.length());
        if(N==1)
        return (Integer.parseInt(a)*Integer.parseInt(b) +"");

        int P = N/2 + N%2;

        String[] A = divide(a);
        String[] B = divide(b);

        String al = A[0];
        String ar = A[1];
        String bl = B[0];
        String br = B[1];

        String p1 = multiply(al,bl);
        String p3 = multiply(ar,br);
        String p2 = multiply(al+ar,bl+br) ;


        String p = Long.valueOf(p1)*Math.pow(10,2*P) + Long.valueOf(p2)*Math.pow(10,P) + Long.valueOf(p3) +"";
        return p;

    }