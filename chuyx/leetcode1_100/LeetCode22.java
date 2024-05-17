package leetcode1_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuxiang_chu
 * @date 2022/11/14 16:34
 */
public class LeetCode22 {

    public static void main(String[] args) {
        Solution solution = new LeetCode22.Solution();
        List<String> strings = solution.generateParenthesis2(8);
        for (String string : strings) {
            System.out.println(string);
        }

    }
    static class Solution {
        ArrayList<String> res = new ArrayList<>();
        // 5.85   5.11
        public List<String> generateParenthesis(int n) {
            test(0,"",n);
            return res;
        }

        private void test(int i, String s, int n) {
            if (s.length() == n*2) {
                if (isOk(s)) {
                    res.add(s);
                }

                return;
            }
            String ns = s + "(";
            int ni = i + 1;
            test(ni, ns, n);
            ns = s + ")";
            test(ni, ns, n);
        }

        private boolean isOk(String toString) {
            char[] chars = toString.toCharArray();
            Stack<Character> characters = new Stack<>();
            for (char aChar : chars) {
                if (aChar == '(') {
                    characters.add(aChar);
                } else {
                    if (characters.isEmpty()) {
                        return false;
                    }
                    characters.pop();
                }
            }
            return characters.isEmpty();
        }



        // 76.93   83.31
        public List<String> generateParenthesis2(int n) {
            int ln = n, rn = 0;
            test2(ln,rn,"");
            return res;
        }

        private void test2(int ln, int rn, String s) {
            if (rn == 0 && ln == 0) {
                res.add(s);
                return;
            }
            if (rn == 0) {
                String ns = s + "(";
                test2(ln-1,rn+1,ns);
                return;
            }
            if (ln > 0) {
                String ns = s + "(";
                test2(ln-1,rn+1,ns);
            }
            String ns = s + ")";
            test2(ln, rn-1,ns);
        }
    }
}
