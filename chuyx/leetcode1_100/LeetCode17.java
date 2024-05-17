package leetcode1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuxiang.chu
 * @date 2022/6/18 17:39
 **/
public class LeetCode17 {


    public static void main(String[] args) {
        Solution solution = new LeetCode17.Solution();

        List<String> strings = solution.letterCombinations("23");
    }


    static class Solution {

        public Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return result;
            }
            backtrack(digits, 0, new StringBuilder());
            return result;
        }

        /**
         * 回溯
         *
         * @param digits  输入值
         * @param index   当前位置
         * @param resItem 当前结果临变量
         */
        public void backtrack(String digits, Integer index, StringBuilder resItem) {
            if (index == digits.length()) {
                result.add(resItem.toString());
            } else {
                char c = digits.charAt(index);
                String strItem = phoneMap.get(c);
                for (int i = 0; i < strItem.length(); i++) {
                    char itemC = strItem.charAt(i);
                    resItem.append(itemC);
                    backtrack(digits, index + 1, resItem);
                    resItem.deleteCharAt(index);
                }
            }
        }

    }


}


