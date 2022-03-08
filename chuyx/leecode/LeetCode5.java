package leecode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * Related Topics 字符串 动态规划 👍 4689 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/2/21 9:09
 **/
public class LeetCode5 {

    public static void main(String[] args) {
        Solution solution = new LeetCode5().new Solution();
        System.out.println(solution.longestPalindrome2("abab"));
    }

    class Solution {
        /**
         * 动态规划，每个独立的字母都是回文串
         * 那么，慢慢变长，变长后两端的字符串相等既是回文串（前提是边长前也是回文串）
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            boolean[][] db = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                db[i][i] = true;
            }

            char[] chars = s.toCharArray();
            int start = 0;
            int manLen = 1;
            // 循环子串长度，因为一个字符串必然是回文串，所以从2-N
            for (int L = 2; L <= len; L++) {
                // 左开始
                for (int i = 0; i < len; i++) {
                    int j = L + i - 1;  // 长度为L，那么右边界即：L + i - 1；
                    if (j >= len) {
                        break; // 右边界超出子串长度，直接解锁循环
                    }
                    if (chars[i] != chars[j]) {
                        db[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            db[i][j] = true;
                        } else {
                            db[i][j] = db[i + 1][j - 1];
                        }
                    }

                    if (db[i][j] && j - i + 1 > manLen) {
                        start = i;
                        manLen = j - i + 1;
                    }
                }
            }
            return s.substring(start, manLen + start);

        }

        public String longestPalindrome2(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                int i2 = expandAroundCenter(s, i, i);
                int i1 = expandAroundCenter(s, i, i + 1);
                int len2 = Math.max(i1, i2);
                if (len2 > end - start) {
                    start = i - (len2 - 1) / 2;
                    end = i + len2 / 2;
                }
            }
            return s.substring(start, end + 1);
        }
        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }
}
