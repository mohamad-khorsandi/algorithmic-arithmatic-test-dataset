package org.example;


import java.util.*;

public class QuickSelect {
    static int kthSmallest(int arr[], int l, int r, int k) {

        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1;

            int i;

            int[] median = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(arr, l + i * 5, l + i * 5 + 5);


            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, l + i * 5 + n % 5);
                i++;
            }


            int medOfMed = (i == 1) ? median[i - 1] :
                    kthSmallest(median, 0, i - 1, i / 2);


            int pos = partition(arr, l, r, medOfMed);


            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }

    static int findMedian(int arr[], int i, int n) {
        Arrays.sort(arr, i, n);
        return arr[i + (n - i) / 2];
    }

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    static int partition(int arr[], int l,
                         int r, int x) {
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x)
                break;
        swap(arr, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
