package com.example.demo.algorithm;

/**
 * @author: zjq
 * @date: 2021/7/21 下午4:07
 * @description: 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     * @param a 无序数组
     * @param p 开始下标
     * @param r 结束下标
     */
    private static void quickSortC(int[] a, int p, int r) {
        //判空或者数组大小为1
        if (p >= r) {
            return;
        }
        //寻找分区基准点
        //int q = baseIndex(a, p, r);
        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    public static int partition(int[] a, int start, int end) {
        //把数组的最后一个元素当作基准元素
        int pivot = a[end];
        /*i j 为比较基准下标  i作为钉子盯准a[i]的元素是否比pivot大 j作为扫描 如果a[i]和a[j]都比基准元素小,则i++且交换元素 如果a[j]比基准元素大 不进行交换且i不变
        但是j继续下次循环 这样i和j的值就不一样了 再次进行遍历时找到下个比pivot小的a[j] 然后进行交换  最后进行a[i] 和 a[end] 进行交换 因为a[i]是比a[end]大的*/
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i = i + 1;
            }
        }
        swap(a, i, end);
        return i;
    }

    public static void swap(int[] a,int i,int j){
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static int baseIndex(int[] a,int start,int end){
        int pivot=a[end];
        int i=start;
        int j=start;
        while (j<end){
            if (a[j]<pivot){
                swap(a,i,j);
                i++;
            }
            j++;
        }
        swap(a, i, end);
        return i;
    }
}
