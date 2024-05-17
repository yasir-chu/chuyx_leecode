package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuxiang_chu
 * @date 2022/11/11 15:03
 */
public class LeetCode1704 {

    public static void main(String[] args) {
        Solution solution = new LeetCode1704.Solution();
        System.out.println(solution.halvesAreAlike("book"));
    }

    static class Solution {
        /**
         * 低效
         */
        public boolean halvesAreAlike(String s) {
            List<Character> yuanyin = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
            int a=0,b=0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (i >= s.length() /2) {
                    if (yuanyin.contains(s.charAt(i))) {
                        b ++;
                    }
                }else{
                    if (yuanyin.contains(s.charAt(i))) {
                        a ++;
                    }
                }

            }
            return a==b;
        }

        /**
         * 少一半遍历次数
         */
        public boolean halvesAreAlike2(String s) {
            List<Character> yuanyin = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
            int a=0,b=0;
            for (int i = 0; i < s.toCharArray().length/2; i++) {
                if (yuanyin.contains(s.charAt(i))) {
                    a ++;
                }
                if (yuanyin.contains(s.charAt(s.length()/2 + i))) {
                    b ++;
                }

            }
            return a==b;
        }

        public boolean halvesAreAlike3(String s) {
            String yy = "aeiouAEIOU";
            int a=0,b=0;
            for (int i = 0; i < s.length()/2; i++) {
                if (yy.indexOf(s.charAt(i)) != -1) {
                    a ++;
                }
                if (yy.indexOf(s.charAt(s.length()/2 + i))!=-1) {
                    b ++;
                }

            }
            return a==b;
        }

        public boolean halvesAreAlike4(String s) {
            int[] yy = new int[123];
            yy['a'] = yy['e'] = yy['i'] = yy['o'] = yy['u'] =  yy['A'] = yy['E'] = yy['I'] = yy['O'] = yy['U'] = 1;
            int a = 0, b = 0;
            for (int i = 0; i < s.length() / 2; i++) {
                if (yy[s.charAt(i)] == 1) {
                    a++;
                }
                if (yy[s.charAt(s.length() / 2 + i)] == 1) {
                    b++;
                }

            }
            return a == b;
        }
    }
}
