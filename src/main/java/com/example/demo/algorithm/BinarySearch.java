package com.example.demo.algorithm;
/**
 * @author: zjq
 * @date: 2021/7/21 下午1:32
 * @description: 二分查找
 */
public class BinarySearch {


    /**
     * 查找有序数组中第一个元素等于给定值的下标,如果没有则返回-1
     * @param array 有序数组
     * @param value 给定的查找值
     * @return 返回
     */
    public static int getFirstElementIndex(int[] array,int value){
        int low=0;
        int high=array.length-1;
        int mid=-1;
        while (low<=high){
            mid=(low+high)>>1;
            if (array[mid]>value)
                high=mid-1;
            else if (array[mid]<value)
                low=mid+1;
            else {
                if ((array[mid]==0)||array[mid-1]!=value) return mid;
                else high=mid-1;
            }
        }
        return -1;
    }
}
