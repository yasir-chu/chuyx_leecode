package leetcode;

import java.util.Arrays;

/**
 * @author yuxiang_chu
 * @date 2023/3/30 15:54
 */
public class LeetCode1013 {


    public static void main(String[] args) {
        Solution solution = new LeetCode1013.Solution();
        int[] a = {1, -1, 1, -1};
        System.out.println(solution.canThreePartsEqualSum3(a));
    }

    static class Solution {
        /**
         * 超时
         *
         * @param arr
         * @return
         */
        public boolean canThreePartsEqualSum(int[] arr) {
            for (int i = 0; i < arr.length - 2; i++) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                    int a = 0, b = 0, c = 0;
                    for (int i1 = 0; i1 <= i; i1++) {
                        a += arr[i1];
                    }
                    for (int j1 = i + 1; j1 <= j; j1++) {
                        b += arr[j1];
                    }
                    for (int k = j + 1; k < arr.length; k++) {
                        c += arr[k];
                    }
                    if (a == b && b == c) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 5.83 && 47.71
         *
         * @param arr
         * @return
         */
        public boolean canThreePartsEqualSum2(int[] arr) {
            int sum = Arrays.stream(arr).sum();
            if (sum % 3 != 0) {
                return false;
            }
            int splitSum = sum / 3;

            int oneSum = 0;
            for (int i = 0; i < arr.length - 2; i++) {
                oneSum += arr[i];
                if (oneSum == splitSum) {
                    int twoSum = 0;
                    for (int j = i + 1; j < arr.length - 1; j++) {
                        twoSum += arr[j];
                        if (twoSum == splitSum) {
                            System.out.println(i + "----" + j);
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean canThreePartsEqualSum3(int[] A) {
            int sum = 0;
            for (int i : A) {
                sum += i;
            }
            if (sum % 3 != 0) {
                // 总和不是3的倍数，直接返回false
                return false;
            }


            int s = 0;
            int flag = 0;
            for (int i : A) {
                s += i;
                if (s == sum / 3) {
                    flag++;
                    s = 0;
                }
            }
            // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
            return flag >= 3;
        }

    }


}
