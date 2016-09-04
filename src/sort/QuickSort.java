package sort;

import util.Util;

/**
 * Created by wdl on 2016/8/24.
 */
public class QuickSort {
    public static void main(String[] args) {
        int num[] = {70, 98, 36, 61, 46, 62, 91, 97 , 78, 83 };
        quicksort(num, 0, num.length -1);
        Util.printInts(num);
    }

    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
