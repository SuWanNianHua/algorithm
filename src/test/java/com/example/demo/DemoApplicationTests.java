package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void recursion() {
        Integer[] ints = gennerateArray(200, 20000);
        mergeSort(ints);

        for (int i = 0; i < ints.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(ints[i] + "  ");
            }
        }
    }


    public static Integer[] gennerateArray(int len, int max) {
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }


    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        T[] tmpArray = (T[]) new Comparable[arr.length];
        mergeSort(arr, tmpArray, 0, arr.length - 1);
    }


    private static <T extends Comparable<? super T>> void mergeSort(T[] arr,
                                                                    T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArray, left, center);
            mergeSort(arr, tmpArray, center + 1, right);
            merge(arr, tmpArray, left, center + 1, right);
        }
    }


    private static <T extends Comparable<? super T>> void merge(T[] arr,
                                                                T[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int numElements = rightEnd - leftPos + 1;
        int tmpPos = leftPos;// 只使用tmpArray中某一部分区域
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos].compareTo(arr[rightPos]) <= 0)
                tmpArray[tmpPos++] = arr[leftPos++];
            else
                tmpArray[tmpPos++] = arr[rightPos++];
        }

        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = arr[leftPos++];// copy rest of left half
        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = arr[rightPos++];// copy rest of right half

        // copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--)
            arr[rightEnd] = tmpArray[rightEnd];//只拷贝当前 merge 的部分数组


    }

    //for test purpose
    public static void main(String[] args) {
        int[] a = {5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 3, 4};
        quickSortC(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public static void bobbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
        for (int i : array) {
            System.out.println(i + "  ");
        }
    }

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
