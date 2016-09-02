/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] data = new int[] { 1100, 192, 221, 12, 23, 222, 111, 134, 178, 8829, 1, 189 };
        print(data);
        radixSort(data, 10, 4);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void radixSort(int[] data, int radix, int maxLeng) {
        // 缓存数组
        int[] tmp = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        int subKey = 0;
        int rate = 1;
        for (int i = 0; i < maxLeng; i++) {

            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int j = data.length - 1; j >= 0; j--) {
                subKey = (tmp[j] / rate) % radix;
                data[--buckets[subKey]] = tmp[j];
            }
            rate *= radix;
        }

    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
