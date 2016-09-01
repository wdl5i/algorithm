package sort;

public class ShellSort {
    public static int count = 0;

    public static void main(String[] args) {

        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        shellSort(data);
        print(data);

    }

    /**
     * 希尔排序（Shell sort）基本思想: 改进的直接插入算法。
     * 设待排序的元素序列有n个元素，首先取一整数gap（<n）作为间隔，
     * 将全部元素分为gap个子序列，所有距离为gap的元素放在同一序列中，
     * 在每个子序列中分别进行直接插入排序。然后缩小gap，例如gap=(gap-1)/3,
     * 重复上述的子序列划分与排序工作。开始由于gap取直大，每个子序列元素少，排序速度快，
     * 待排序后期，gap值逐渐变小，子序列元素变多，
     * 但由于前面的工作基础，大多数元素已经有序，所以排序速度快。
     * @param data
     */
    public static void shellSort(int[] data) {
        // 计算出最大的gap值
        int gap = 1;
        while (gap <= data.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int currtIndex = gap; currtIndex < data.length; currtIndex += gap) {
                int prevIndex = currtIndex - gap;
                if (data[prevIndex] > data[currtIndex]) {
                    int currtVal = data[currtIndex];
                    while (prevIndex >= 0 && data[prevIndex] > currtVal) {
                        data[prevIndex + gap] = data[prevIndex];
                        prevIndex -= gap;
                    }
                    data[prevIndex + gap] = currtVal;
                    print(data);
                }
            }
            // 计算出下一个gap值
            gap = (gap - 1) / 3;
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}
