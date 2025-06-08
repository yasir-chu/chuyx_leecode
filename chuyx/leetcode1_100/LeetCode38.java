package leetcode1_100;

public class LeetCode38 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Solution.countAndSay(4));
    }


    static class Solution {


        /**
         * 1 - 1
         * 2 - 11
         * 3 - 21
         * 4 - 1211
         * 5 - 111221
         * 6 = 312211
         * 7 = 13112221
         * 8 = 1113212311
         *
         * 执行耗时:2 ms,击败了82.57% 的Java用户
         * 内存消耗:40.4 MB,击败了89.19% 的Java用户
         * @param n
         * @return
         */
        public static String countAndSay(int n) {
            return n == 1 ? "1" : journeyLengthCode(countAndSay(n-1));
        }


        /**
         * 1 -> 11
         * 11 -> 21
         * 21 -> 1211
         * @param str
         * @return
         */
        public static String journeyLengthCode(String str) {
            StringBuilder res = new StringBuilder();
            int count = 1;
            char equalsChar = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                if (equalsChar == str.charAt(i)) {
                    count ++;
                }else {
                    res.append(count).append(equalsChar);
                    equalsChar = str.charAt(i);
                    count = 1;
                }
            }
            res.append(count).append(equalsChar);
            return res.toString();
        }
    }
}
