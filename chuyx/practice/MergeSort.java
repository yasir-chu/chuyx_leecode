package practice;

/**
 * 归并排序
 * @author yuxiang.chu
 * @date 2022/2/8 9:23
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        mergeSort(a, a.length);
        }

    private static void mergeSort(int[] arr, int n){
        mergeSortInternally(arr, 0, n -1);
    }

    private static void mergeSortInternally(int[] arr, int i, int j) {
        if (i >= j){
            return;
        }
        // 取i j 的中间位置
        int k = i/2+j/2;
        mergeSortInternally(arr, i, k);
        mergeSortInternally(arr, k+1, j);

        merge(arr,i,k,j);
    }

    private static void merge(int[] arr, int start, int center, int end) {
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
}
