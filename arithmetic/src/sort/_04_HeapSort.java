package sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _04_HeapSort {

    public static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }
        for (int j = a.length - 1; j > 0; j--) {
            SortUtil.swap(a, 0, j);
            adjust(a, 0, j);
        }
    }

    public static void adjust(int[] a, int i, int length) {
        int temp = a[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && a[k] < a[k + 1]) {
                k++;
            }
            if (a[k] > temp) {
                SortUtil.swap(a, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 6, 1, 3, 9, 8, 10, 11, 6, 4, 2};
        //int a[] = {9,1,12,8,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
