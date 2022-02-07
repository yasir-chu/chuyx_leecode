package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序算法
 *
 * @author yuxiang.chu
 * @date 2022/2/7 15:51
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] sortList = {6, 4, 2, 1, 3, 5};


        for (int i = 1; i < sortList.length; i++) {
            int value = sortList[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (sortList[j] > value) {
                    sortList[j+1] = sortList[j];
                } else {
                    break;
                }
            }
            sortList[j + 1] = value;
        }

        System.out.println(Arrays.toString(sortList));

    }
}
