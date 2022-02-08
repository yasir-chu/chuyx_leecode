package practice;

/**
 * 快排
 * @author yuxiang.chu
 * @date 2022/2/8 11:05
 **/
public class QuitSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        quickSortInternally(arr,0, arr.length-1);
    }

    private static void quickSortInternally(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int point = partition(arr,start, end);
        quickSortInternally(arr, start, point-1);
        quickSortInternally(arr, point + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot){
                if (i == j){
                    i++;
                }else{
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int tmp = arr[i];
        arr[i] = arr[end];
        arr[end] = tmp;

        return i;

    }


}

