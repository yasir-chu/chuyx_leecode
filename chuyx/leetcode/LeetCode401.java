package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiang.chu
 * @date 2022/6/28 9:42
 **/
public class LeetCode401 {

    public static void main(String[] args) {
        Solution solution = new LeetCode401.Solution();
        List<String> strings = solution.readBinaryWatch(9);
    }


    static class Solution {

        public List<String> result = new ArrayList<>();

        /**
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:40 MB,击败了80.26% 的Java用户
         * @return 结果
         */
        public List<String> readBinaryWatch(int turnedOn) {
            int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < 10; i++) {
                huisu(i, turnedOn, 0, arr);
            }
            return result;
        }

        /**
         *
         * @param nowOn 现在开到第几个灯
         * @param turnedOn 一共要开几个灯
         * @param ready 已经开了多少灯
         * @param arr 数组 1开0关
         */
        public void huisu(int nowOn, int turnedOn, int ready, int[] arr) {
            if (ready == turnedOn) {
                String str = getStr(arr);
                if (str == null) {
                    return;
                }
                result.add(str);
                return;
            }
            for (int i = nowOn; i < 10; i++) {
                // 亮
                arr[i] = 1;
                ready++;
                huisu(i + 1, turnedOn, ready, arr);
                // 恢复现场
                ready--;
                arr[i] = 0;
            }
        }

        private String getStr(int[] arr) {
            int hour = 0, min = 0;
            for (int i = 0; i < 4; i++) {
                hour += arr[i] * (int) Math.pow(2, 3 - i);
            }
            for (int i = 4; i < 10; i++) {
                min += arr[i] * (int) Math.pow(2, 9 - i);
            }
            if (hour > 11 || min > 59) {
                return null;
            }
            StringBuilder str = new StringBuilder();
            str.append(hour).append(":");
            if (min < 10) {
                str.append("0").append(min);
            } else {
                str.append(min);
            }
            return str.toString();
        }
    }
}
