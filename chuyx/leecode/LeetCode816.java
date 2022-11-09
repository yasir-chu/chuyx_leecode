package leecode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiang_chu
 * @date 2022/11/7 13:48
 */
public class LeetCode816 {


    public static void main(String[] args) {
        Solution solution = new LeetCode816().new Solution();
        String str = "(123)";
        List<String> strings = solution.ambiguousCoordinates2(str);
        for (String string : strings) {
            System.out.print(string + ";");
        }
    }

    class Solution {
        private List<String> res = new ArrayList<>();
        // 笨蛋方法
        public List<String> ambiguousCoordinates(String s) {

            // ,
            s = s.substring(1, s.length() - 1);
            for (int i = 0; i < s.length(); i++) {
                checkIsOk(s.substring(0, i) + "," + s.substring(i));
            }
            return res;
        }

        private void checkIsOk(String str) {
            String[] split = str.split(",");
            if (split.length != 2) {
                return;
            }
            for (int i = 0; i < split[0].length(); i++) {
                String one = split[0].substring(0, i) + "." + split[0].substring(i);
                one = checkVaild(one);
                if (one == null) {
                    continue;
                }
                for (int j = 0; j < split[1].length(); j++) {
                    String two = split[1].substring(0, j) + "." + split[1].substring(j);
                    two = checkVaild(two);
                    if (two != null) {
                        res.add("(" + one + ", " + two + ")");
                    }
                }
            }
        }

        /**
         * 检验合法  不允许0开头的整数 除非本身是0   不允许0结尾的小数
         * @param s
         * @return
         */
        private String checkVaild(String s) {
            if (s.startsWith(".") || s.endsWith(".")) {
                s = s.replaceAll("\\.", "");
            }
            if (s.contains(".") && s.endsWith("0")) {
                return null;
            }
            if (s.contains(".") && s.startsWith("0") && !s.startsWith("0.")) {
                return null;
            }
            if (!s.contains(".") && s.startsWith("0") && s.length() > 1) {
                return null;
            }
            try {
                double v = Double.parseDouble(s);
                if (v == 0 && s.length() != 1) {
                    return null;
                }

            }catch (Exception e) {
                return null;
            }
            return s;
        }



        public List<String> ambiguousCoordinates2(String s) {

            // ,
            s = s.substring(1, s.length() - 1);
            for (int i = 1; i < s.length(); i++) {
                for (String one : getNums(s.substring(0, i))) {
                    for (String two : getNums(s.substring(i))) {
                        res.add("(" + one + ", " + two  +")");
                    }
                }
            }
            return res;
        }

        private List<String> getNums(String itemStr) {
            List<String> res = new ArrayList<>();
            String left, right;
            for (int i = 1; i <= itemStr.length(); i++) {
                left = itemStr.substring(0,i);
                right = itemStr.substring(i);
                // 整数0开头，小数0结尾的 都不合法
                if (left.startsWith("0") && !"0".equals(left) || right.endsWith("0")) {
                    continue;
                }
                if (right.isEmpty()) {
                    res.add(left);
                } else {
                    res.add(left + "." + right);
                }
            }
            return res;
        }
    }
}
