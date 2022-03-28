package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/3/10 18:04
 **/
public class LeetCode6 {

    public static void main(String[] args) {
        Solution solution = new LeetCode6().new Solution();
        System.out.println(solution.convert("AB", 1));  // PINALSIGYAHRPI
    }


    class Solution {
        /**
         * 纯找规律
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            char[] chars = s.toCharArray();
            int manSize = chars.length;
            StringBuilder result = new StringBuilder();
            int len = 0;
            for (int i = 0; i < manSize && len < numRows; i++) {
                if (len == 0 || len == numRows - 1){
                    result.append(chars[len]);
                    int addSize = numRows == 1 ? 1: (numRows - 1) * 2;
                    int item = len + addSize;
                    while (item < manSize && addSize != 0){
                        result.append(chars[item]);
                        item = item + addSize;
                    }
                }else{
                    result.append(chars[len]);
                    int num = 0;
                    int addSize = (numRows - 1 - len) * 2;
                    int item = len + addSize;
                    while (item < manSize && addSize != 0){
                        result.append(chars[item]);
                        if (num % 2 != 0){
                            item = item + addSize;
                        }else{
                            item = item + 2*len;
                        }
                        num++;
                    }
                }
                len ++;
            }
            return result.toString();
        }
    }
}
