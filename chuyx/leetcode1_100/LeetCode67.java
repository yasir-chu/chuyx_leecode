package leetcode1_100;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 位运算 数学 字符串 模拟 👍 663 👎 0

import java.util.ArrayList;

/**
 * @author yuxiang.chu
 * @date 2021/10/8 18:24
 **/
public class LeetCode67 {


    public static void main(String[] args) {
        Solution solution = new LeetCode67.Solution();
        System.out.println(solution.addBinary2("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }


    static class Solution {
        /**
         * 硬算
         */
        public String addBinary(String a, String b) {
            int max = Math.max(a.length(), b.length());
            char[] result = new char[max + 1];
            char[] chars = a.toCharArray();
            char[] chars1 = b.toCharArray();
            boolean flag = false;
            int x = 0;
            for (int i = max - 1; i >= 0; i--) {
                x ++;
                char aa = '0', bb = '0';
                if (a.length() == max) {
                    aa = chars[i];
                } else {
                    int aaI = a.length() - x;
                    if (aaI >= 0 &&aaI < a.length()){
                        aa = chars[aaI];
                    }
                }
                if (b.length() == max) {
                    bb = chars1[i];
                } else {
                    int bbI = b.length() - x;
                    if (bbI >= 0 &&bbI < b.length()){
                        bb = chars1[bbI];
                    }
                }
                if (aa == '0' && bb == '0') {
                    if (flag) {
                        result[i + 1] = '1';
                    } else {
                        result[i + 1] = '0';
                    }
                    flag = false;
                }
                if (aa == '1' && bb == '1') {
                    if (flag) {
                        result[i + 1] = '1';
                    } else {
                        result[i + 1] = '0';
                    }
                    flag = true;
                }
                if (aa == '1' && bb == '0') {
                    if (flag) {
                        result[i + 1] = '0';
                        flag = true;
                    } else {
                        result[i + 1] = '1';
                    }
                }
                if (aa == '0' && bb == '1') {
                    if (flag) {
                        result[i + 1] = '0';
                        flag = true;
                    } else {
                        result[i + 1] = '1';
                    }
                }
            }
            int start = 0;
            if (flag){
                result[0] = '1';
            }else{
                start = 1;
            }
            StringBuilder s = new StringBuilder();
            for (int i = start; i < result.length; i++) {
                s.append(result[i]);
            }
            return s.toString();
        }

        /**
         * 先转换成十进制再转换成二进制
         * 注意：会有Integer越界的情况  换成long值试一下    Long最终还是会越界
         */
        public String addBinary2(String a, String b){
            Long integer = binaryToDecimal(a);
            Long integer2 = binaryToDecimal(b);
            Long i = integer + integer2;
            return decimalToBinary(i);
        }

        public Long binaryToDecimal(String a){
            char[] chars = a.toCharArray();
            Long num = 0L;
            for (int i = 0; i < chars.length; i++) {
                Long item = Long.valueOf(String.valueOf(chars[i]));
                Long dd = 1L;
                for (int j = 0; j < chars.length - 1 - i; j++) {
                    dd = dd * 2L;
                }

                num += item * dd;
            }
            return num;
        }

        public String decimalToBinary(Long a){
            ArrayList<Integer> integers = new ArrayList<>();
            while (true){
                if (a % 2 == 1){
                    integers.add(1);
                }else{
                    integers.add(0);
                }
                a = a/2;
                if (a == 1){
                    integers.add(1);
                    break;
                }if (a == 0){
                    break;
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = integers.size() - 1; i >=0 ; i--) {
                result.append(integers.get(i));
            }
            return result.toString();
        }
    }



}
