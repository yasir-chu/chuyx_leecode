package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @author yuxiang_chu
 * @date 2022/10/26 9:24
 */
public class LeetCode862 {

    public static void main(String[] args) {
        Solution solution = new LeetCode862.Solution();
        int[] a = {1};
        System.out.println(solution.shortestSubarrayNiubi(a, 1));
    }

    static class Solution {
        // 超时答案
        public int shortestSubarray(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int itemRes = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if ((sum = sum + nums[j]) < k) {
                        itemRes++;
                    } else {
                        sum = 0;
                        min = Math.min(itemRes, min);
                        itemRes = 1;
                    }
                }
                sum = 0;
                itemRes = 1;
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        // 超时2 对比1 减少了遍历次数
        public int shortestSubarray2(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int itemRes = 1;
            int offset = 0;
            for (int i = 0; offset < nums.length; i++) {
                if ((sum += nums[i]) < k) {
                    itemRes++;
                } else {
                    min = Math.min(itemRes, min);
                    i = offset;
                    offset ++ ;
                    itemRes = 1;
                    sum = 0;
                }
                if (i == nums.length - 1) {
                    i = offset;
                    offset ++;
                    itemRes = 1;
                    sum = 0;
                }

            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }


        // 超时3 对比2 跳过了以负数开头的子数组
        public int shortestSubarray3(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int itemRes = 1;
            int offset = 0;
            for (int i = 0; offset < nums.length; i++) {
                if ((sum += nums[i]) < k) {
                    itemRes++;
                    if (i == offset + 1 && nums[i] <= 0) {
                        offset = i;
                    }
                } else {
                    min = Math.min(itemRes, min);
                    i = offset;
                    offset ++ ;
                    itemRes = 1;
                    sum = 0;
                }
                if (i == nums.length - 1) {
                    i = offset;
                    offset ++;
                    itemRes = 1;
                    sum = 0;
                }

            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public int shortestSubarrayNiubi(int[] nums, int k) {
            int res = Integer.MAX_VALUE;
            // 计算新数组 表示前缀数组和  子数组可以用对应位置的前缀的差值
            long[] prefixArray = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixArray[i+1] = prefixArray[i] + nums[i];
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < prefixArray.length; i++) {
                long cus = prefixArray[i];
                while (!q.isEmpty() && (cus - prefixArray[q.peekFirst()]) >= k) {
                    res = Math.min(res, i - q.pollFirst());
                }
                while (!q.isEmpty() && prefixArray[q.peekLast()] >= cus) {
                    q.pollLast();
                }
                q.addLast(i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }


        public int shortestSubarrayNiubi2(int[] nums, int k) {
            int res = Integer.MAX_VALUE;
            Deque<Pair<Long, Integer>> q = new ArrayDeque<>();
            q.add(new Pair<>(0L, -1));
            long cus = 0;
            for (int i = 0; i < nums.length; i++) {
                cus += nums[i];
                while (!q.isEmpty() && (cus - q.peekFirst().getKey()) >= k) {
                    res = Math.min(res, i - Objects.requireNonNull(q.pollFirst()).getValue());
                }
                while (!q.isEmpty() && q.peekLast().getKey()>= cus) {
                    q.pollLast();
                }
                q.addLast(new Pair<>(cus, i));
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
