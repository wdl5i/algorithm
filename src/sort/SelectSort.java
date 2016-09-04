package sort;

import util.Util;

/**
 * Created by wdl on 2016/8/11.
 */
public class SelectSort {
    public static void main(String[] args) {
        int num[] = Util.randomInts(20);
        new SelectSort().selSort(num);
        Util.printInts(num);
    }

    /*----------------------------选择排序法-------------------------------------------
			  将要排序的对象分作两部份，一个是已排序的，一个是未排序的，
              从后端未排序部份选择一个最小值，并放入前端已排序部份的最后一个。
       -------------------------------------------------------------------------------*/
    public void selSort(int array[]) {
        int minIndex = 0, temp = 0;
        //i之前的都是已排完序的数组，i和i之后的都是未排好序的数组
        //取i之后的所有数据中的最小值与i比较，如果最小值小于i,则交换
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

}
