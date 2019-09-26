class Sort 
{
   
    public static void mergeSort(int arr[], int a, int b) 
   {
        if (a < b) 
	{
            int m = (a + b) / 2;
            mergeSort(arr, a, m);
            mergeSort(arr, m + 1, b);
            merge(arr, a, m, b);

        }

    }


    private static void merge(int arr[], int a, int m, int b) {
        int f = m - a + 1;
        int s = b - m;


        int t1[] = new int[f];
        int t2[] = new int[s];

        for (int i = 0; i < f; i++)
            t1[i] = arr[i + a];
        for (int i = 0; i < s; i++)
            t2[i] = arr[i + m + 1];


        int i = 0, j = 0, k = a;
        while (i < f && j < s) {
            if (t1[i] <= t2[j]) {
                arr[k] = t1[i];
                i++;
            } else {
                arr[k] = t2[j];
                j++;
            }
            k++;

        }

        while (i < f) {
            arr[k] = t1[i];
            i++;
            k++;
        }
        while (j < s) {
            arr[k] = t2[j];
            j++;
            k++;
        }

    }
}

