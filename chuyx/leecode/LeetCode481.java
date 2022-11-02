package leecode;

/**
 * @author yuxiang_chu
 * @date 2022/10/31 10:08
 */
public class LeetCode481 {

    public static void main(String[] args) {
        Solution solution = new LeetCode481().new Solution();
        System.out.println(solution.magicalString(2));
    }

    class Solution {

        /**
         * 内存消耗多，因为借助了数组。
         * @param n
         * @return
         */
        public int magicalString(int n) {
            int slow = 1;
            int res = 1;
            int[] arr = new int[n];
            arr[0] = 1;
            int item = 2;
            int flowSize = 2;
            for (int i = 1; i < n; i += flowSize) {
                for (int j = 0; j < flowSize; j++) {
                    if (i+j >= n) {
                        break;
                    }
                    arr[i+j] = item;
                    res = item == 1 ? res + 1 : res;
                }
                item = item == 1? 2:1;
                slow++;
                if (slow >= arr.length) {
                    break;
                }
                flowSize = arr[slow];
            }
            return res;
        }


        public int magicalString2(int n) {
            int[] arr = new int[n];
            int res = 0;
            arr[0] = 1;arr[1] = 2;arr[2] = 2;
            int r = 2;
            while (r < n) {
            }

            for (int i : arr) {
                res = i == 1 ? res + 1: res;
            }
            return res;
        }
    }
}
