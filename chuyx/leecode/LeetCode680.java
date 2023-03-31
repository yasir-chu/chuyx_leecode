package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/3/31 15:52
 */
public class LeetCode680 {

    public static void main(String[] args) {
        Solution solution = new LeetCode680().new Solution();
        System.out.println(solution.validPalindrome2("cbbcc"));
    }

    class Solution {
        // 19.27 86.26
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                break;
            }
            // 是否是回文串
            if (left >= right) {
                return true;
            }
            // 删除left
            int newL = left+ 1;
            int newR = right;
            while (newL < newR) {
                if (s.charAt(newL) != s.charAt(newR)) {
                    break;
                }
                newL++;
                newR--;
            }
            if (newL >= newR) {
                return true;
            }
            // 删除right
            newL = left;
            newR = right - 1;
            while (newL < newR) {
                if (s.charAt(newL) != s.charAt(newR)) {
                    break;
                }
                newL++;
                newR--;
            }
            return newL >= newR;
        }


        // 55.92 31.79
        public boolean validPalindrome2(String s) {
            int left = 0;
            int right = s.length() -1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                return chackIs(s, left+1, right) || chackIs(s, left, right-1);
            }
            return true;
        }

        private boolean chackIs(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                return false;
            }
            return true;
        }
    }




}
