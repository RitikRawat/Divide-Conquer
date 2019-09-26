class Sort {
    public static void mergeSort(int arr[], int a, int b) {
        if (a < b) {
            int m1 = a + (b - a + 1) / 3;
            int m2 = a + 2 * (b - a + 1) / 3;

            mergeSort1(arr, a, m1);
            mergeSort1(arr, m1 + 1, m2);
            mergeSort1(arr, m2 + 1, b);
            merge(arr, a, m1, m2, b);
        }

    }

    

    private static void merge(int arr[], int a, int m1, int m2, int b) {
        int f = m1 - a + 1;
        int s = m2 - m1;
        int t = b - m2;


        int t1[] = new int[f];
        int t2[] = new int[s];
        int t3[] = new int[t];

        System.arraycopy(arr, a, t1, 0, f);
        System.arraycopy(arr, m1 + 1, t2, 0, s);
        System.arraycopy(arr, m2 + 1, t3, 0, t);

        int i = 0, j = 0, q = 0, k = a;
        while (i < f && j < s && q < t) {
            if (t1[i] <= t2[j] && t1[i] <= t3[q]) {
                arr[k] = t1[i];
                i++;
            } else if (t2[j] <= t1[i] && t2[j] <= t3[q]) {
                arr[k] = t2[j];
                j++;
            } else if (t3[q] <= t1[i] && t3[q] <= t2[j]) {
                arr[k] = t3[q];
                q++;
            }
            k++;

        }

        if (q == t) {
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
        } else if (i == f) {
            while (q < t && j < s) {
                if (t3[q] <= t2[j]) {
                    arr[k] = t3[q];
                    q++;
                } else {
                    arr[k] = t2[j];
                    j++;
                }
                k++;

            }
        } else if (j == s) {
            while (i < f && q < t) {
                if (t1[i] <= t3[q]) {
                    arr[k] = t1[i];
                    i++;
                } else {
                    arr[k] = t3[1];
                    q++;
                }
                k++;

            }
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
        while (q < t) {
            arr[k] = t3[q];
            q++;
            k++;
        }

    }

    
}

