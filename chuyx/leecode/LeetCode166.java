package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxiang_chu
 * @date 2023/7/6 16:22
 */
public class LeetCode166 {


    public static void main(String[] args) {
        Solution solution = new LeetCode166().new Solution();
        System.out.println(solution.fractionToDecimal(7, -12));
    }

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder res = new StringBuilder();
            long fz = numerator, fm = denominator;
            if (fz * fm < 0) {
                res.append("-");
            }
            fm = Math.abs(fm);
            fz = Math.abs(fz);
            res.append(fz / fm);
            long ys = fz % fm;
            if (ys == 0) {
                return res.toString();
            }
            Map<String, Integer> map = new HashMap<>();
            res.append(".");
            while (ys != 0) {
                if (map.containsKey(String.valueOf(ys))) {
                    return String.format("%s(%s)", res.substring(0, map.get(String.valueOf(ys))), res.substring(map.get(String.valueOf(ys))));
                } else {
                    map.put(String.valueOf(ys), res.length());
                }
                res.append(ys * 10 / fm);
                ys = ys * 10 % fm;
            }
            return res.toString();
        }
    }
}
