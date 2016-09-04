package sort;

import util.Util;

/**
 * Created by wdl on 2016/8/11.
 */
 /*-----------------------------------------冒泡排序法----------------------------------------
					   顾名思义，就是排序时，最大的元素会如同气泡一样移至右端，其利用比较相邻元素的方法，将大的元素交换至右端，
              所以大的元素会不断的往右移动，直到适当的位置为止。
                      基本的气泡排序法可以利用旗标的方式稍微减少一些比较的时间，当寻访完阵列后都没有发生任何的交换动作，
             表示排序已经完成，而无需再进行之后的回圈比较与交换动作。
             时间复杂度为O(n^2)
       ----------------------------------------------------------------------------------------*/
public class BubbleSort {

    public static void main(String[] args) {
        int num[] = Util.randomInts(20);
        new BubbleSort().bubbleSort(num);
        Util.printInts(num);
    }

    public void bubbleSort(int array[]) {
        int temp = 0;
        boolean switched = true;
        for (int i = 0; i < array.length - 1 && switched ; i++) {
            switched = false;
            //如果在一次冒泡运算过程中，没有任何数据交换，则表示整个数组已排好
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    switched = true;
                }
            }
        }
    }
}
