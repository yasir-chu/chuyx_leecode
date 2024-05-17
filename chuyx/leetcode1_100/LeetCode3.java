package leetcode1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxiang_chu
 * @since 2024/5/14 10:36
 */
public class LeetCode3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }


    static class Solution {

        /**
         * 耗时 5.00
         * 内存 5.03
         */
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charMap = new HashMap<>(s.length());
            int maxSize = 0;
            for (int i = 0; i < s.length(); i++) {
                if (charMap.containsKey(s.charAt(i))) {
                    maxSize = Math.max(maxSize, charMap.size());
                    i = charMap.get(s.charAt(i));
                    charMap.clear();
                }else {
                    charMap.put(s.charAt(i), i);
                }
            }
            if (!charMap.isEmpty()) {
                return Math.max(charMap.size(), maxSize);
            }
            return maxSize;

        }

    }
}
