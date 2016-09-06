package sort;

import util.Util;

/**
 * Created by wdl on 2016/8/11.
 */
public class HeapSort {
    /*-----------------------heap排序（堆排序法--改进的选择排序）----------------------------
           利用堆积树的原理，先构造一个堆积树（看堆积树的定义，笔记本上有），然后将根节点与最后的叶子节点交换，
           并屏蔽掉最后一个叶子节点，
           然后再将未被屏蔽的部分重新构造堆积树，然后再重复上面的步骤，直到所有的数被按顺序排好。
    --------------------------------------------------------------------------------*/
    public static void main(String[] args) {
        /*int num[] = Util.randomInts(20);
        new BubbleSort().bubbleSort(num);
        Util.printInts(num);*/

        int num[] = Util.randomInts(8);
        heapSort(num);
        System.out.println("排序后的数组：");
        print(num);
    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }

    public static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int selectedIndex = i;
            // 若当前节点的子节点存在
            while  (2 * selectedIndex + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                 int biggerIndex = 2 * selectedIndex + 1;
                if (biggerIndex < lastIndex) { //有右侧节点
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (data[selectedIndex] < data[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, selectedIndex, biggerIndex);
                    selectedIndex = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
