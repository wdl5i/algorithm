package sort;

/**
 * Created by wdl on 2016/8/11.
 */
public class ShakerSort {
    /*---------------------Shake排序法（改良的冒泡排序法）--------------------------
              方法就在于气泡排序的双向进行，先让气泡排序由左向右进行，再来让气泡排序由右往左进行，
              如此完成一次排序的动作，而您必须使用left与right两个旗标来记录左右两端已排序的元素位置。
    --------------------------------------------------------------------*/
    public void shakersort(int array[]) {
        int i, temp, left = 0, right = array.length - 1, shift = 0;
        long start,end;

        start=System.nanoTime();
        while(left < right) {
            // 向右進行氣泡排序
            for(i = left; i < right; i++) {
                if(array[i] > array[i+1]) {
                    temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    shift = i;
                }
            }
            right = shift;

            // 向左進行氣泡排序
            for(i = right; i > left; i--) {
                if(array[i] < array[i-1]) {
                    temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                    shift = i;
                }
            }
            left = shift;
        }
        end=System.nanoTime();

        System.out.println("-----------------shake排序法（改进的冒泡排序法）------------------");
        System.out.print("排序后是:");
        for(i=0;i<= array.length -1;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("排序使用时间："+(end-start)+" ns");
    }
}
