package util;

/**
 * Created by wdl on 2016/8/11.
 */
public class Util {
    public static int[] randomInts(int length) {
        int num[]=new int[length];
        {
            System.out.print("生成的随机数组是：");
            for(int i=0;i<length;i++){
                num[i]=(int)(Math.random()*100);
                System.out.print(num[i]+" ");
            }
            System.out.println();
        }
        return num;
    }

    public static void printInts(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
