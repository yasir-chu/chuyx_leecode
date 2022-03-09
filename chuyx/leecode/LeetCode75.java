package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/2/23 11:18
 **/
public class LeetCode75 {

    public static void main(String[] args) {
        Solution solution = new LeetCode75().new Solution();
        int[] arr = {1,1,2};
        solution.sortColors(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    class Solution {

        // 边界有很多！
        public void sortColors(int[] nums) {
            int head = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, head);
                    head++;
                }
            }
            int len = nums.length;
            for (int i = head; i < len; i++) {
                if (nums[i] == 2) {
                    while (len-1 >= 0 && nums[len-1] == 2 && len - 1 != i){
                        len--;
                    }
                    if (len - 1 >= 0 && len-1>head){
                        swap(nums, i, len - 1);
                        len--;
                    }
                }
            }
        }

        public void swap(int[] arr, int i, int j) {
            int item = arr[i];
            arr[i] = arr[j];
            arr[j] = item;
        }
    }
}
