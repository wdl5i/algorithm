package sort;

import util.Util;

/**
 * Created by wdl on 2016/8/11.
 */
/*-------------------------插入排序法--------------------------------
				像是玩朴克一样，我们将牌分作两堆，每次从后面一堆的牌抽出最前端的牌，然后插入前面一堆牌的适当位置
  -----------------------------------------------------------------*/
public class InsertSort {
    public static void main(String[] args) {
        int num[] = Util.randomInts(20);
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(num);
        Util.printInts(num);
        String a = "abc";
        insertSort.strAppend(a);
        System.out.println(a);
    }

    public void insertSort(int[] array) { 
        int selected = 0, j;
        for (int i = 1; i < array.length; i++) {
            selected = array[i];
            for (j = i; j > 0 && selected < array[j-1]; j--) {
                array[j] = array[j-1];
            }
            array[j] = selected;
        }
    }

    private void strAppend(String str) {
        str = "(" + str + ")";
    }
}
