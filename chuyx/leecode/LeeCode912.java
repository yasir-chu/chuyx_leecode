package leecode;

import java.util.Arrays;


/**
 * @author yuxiang.chu
 * @date 2022/3/4 9:18
 **/
public class LeeCode912 {

    public static void main(String[] args) {
        Solution solution = new LeeCode912().new Solution();
        int[] a = {-4,0,7,4,9,-5,-1,0,-7,-1};
        int[] ints = solution.sortArray(a);
        for (int anInt : ints) {
            System.out.print(anInt+"  ");
        }
    }


    class Solution {
        // 快排
        public int[] sortArray(int[] nums) {
            quikSort2(nums, 0, nums.length - 1);
            return nums;
        }

        private void quitSort(int[] nums, int start, int end) {
            if (end <= start){
                return;
            }
            int p = getPartion(nums, start, end);

            quitSort(nums, start ,p - 1);
            quitSort(nums, p + 1,end);

        }

        private int getPartion(int[] a, int p, int r) {
            // todo 优化成随机取值
            int pivot = a[r];
            int i = p;
            for (int j = p; j < r; ++j) {
                if (a[j] < pivot) {
                    if (i != j) {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                    i++;
                }
            }

            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;

            return i;
        }
    }


    // 归并排序
    public int[] sortArray2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if (r <= l){
            return nums;
        }
        int c = l/2 +r/2;
        mergeSort(nums, l , c);
        mergeSort(nums, c+1, r);

        merge(nums,l,c,r);
        return nums;
    }

    private void merge(int[] arr, int start, int center, int end) {
        int i = start;
        int j = center +1;
        int k = 0;
        int[] tmp = new int[end - start + 1];

        while (i <= center && j <= end){
            if (arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start2 = i;
        int end2 = center;
        if (j <= end) {
            start2 = j;
            end2 = end;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start2 <= end2) {
            tmp[k++] = arr[start2++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= end - start; ++i) {
            arr[start+i] = tmp[i];
        }
    }


    public void quikSort2(int[] arr, int start, int end){
        if (end <= start){
            return;
        }

        int partion2 = getPartition2(arr, start, end);

        quikSort2(arr, start, partion2-1);
        quikSort2(arr, partion2+1,end);
    }

    /**
     * 快排 2
     * @param arr 数组
     * @param start 快排头
     * @param end 快排尾
     */
    public int getPartition2(int[] arr, int start, int end){
        int tmp = arr[end];
        int i = start, j = end;
        boolean flag = true;
        while (i < j){
            if (flag){
                if (arr[i] > tmp){
                    swap(arr, i, j);
                    j--;
                    flag = false;
                }else{
                    i++;
                }
            }else{
                if (arr[j] <= tmp){
                    swap(arr, i, j);
                    i++;
                    flag = true;
                }else{
                    j--;
                }
            }
        }

        return i;

    }

    private void swap(int[] arr, int i, int j) {
        int item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }
}
