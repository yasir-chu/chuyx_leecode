package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuxiang_chu
 * @date 2023/4/3 17:27
 */
public class LeetCode409 {

    public static void main(String[] args) {
        Solution solution = new LeetCode409.Solution();
        System.out.println(solution.longestPalindrome2("abccccdd"));
    }

    static class Solution {
        // 29.45 5.30
        public int longestPalindrome(String s) {
            Set<Character> calculateSet = new HashSet<>(s.length());
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (calculateSet.contains(s.charAt(i))) {
                    calculateSet.remove(s.charAt(i));
                    count += 2;
                } else {
                    calculateSet.add(s.charAt(i));
                }
            }
            return calculateSet.size() > 0 ? count + 1 : count;

        }

        // 13.20 20.75
        public int longestPalindrome2(String s) {
            Map<Character, Integer> map = new HashMap<>(s.length() / 2 + 1);
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            int count = 0;
            for (Character character : map.keySet()) {
                count += map.get(character) * 2 / 2;
            }
            return count;
        }

        // 100 89.01
        public int longestPalindrome3(String s) {
            int[] count = new int[128];
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                count[c]++;
            }
            int ans = 0;
            for (int v : count) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
