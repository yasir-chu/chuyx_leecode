package leetcode;

/**
 * @author yuxiang_chu
 * @date 2023/3/30 17:14
 */
public class LeetCode605 {

    public static void main(String[] args) {
        Solution solution = new LeetCode605.Solution();
        int[] a = {1,0, 0, 0, 1};
        System.out.println(solution.canPlaceFlowers2(a, 1));
    }

    static class Solution {

        /**
         * 超时
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            for (int i = 0; i < flowerbed.length; ) {
                if (flowerbed[i] == 1) {
                    // 当前已种花
                    i = i + 2;
                    continue;
                }
                // 边界判断
                if (i - 1 < 0 && i + 1 >= flowerbed.length) {
                    i++;
                    continue;
                }
                if (i - 1 < 0 && flowerbed[i + 1] == 0) {
                    n--;
                    i = i + 2;
                } else if (i + 1 >= flowerbed.length && flowerbed[i - 1] == 0) {
                    n--;
                    i = i + 2;
                } else if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                    i = i + 2;
                }
            }
            return n <= 0;
        }


        public boolean canPlaceFlowers2(int[] flowerbed, int n) {
            int count = 0;
            int left = -1;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    if (left < 0) {
                        count += i/2;
                    }else {
                        count += (i-left -2) /2;
                    }
                    left = i;
                }
            }
            // 最右边情况
            if (left < 0) {
                count += (flowerbed.length + 1) /2;
            }else{
                count += (flowerbed.length - left -1) /2; // 这里减一是因为边界
            }
            return count >=n;
        }
    }
}
