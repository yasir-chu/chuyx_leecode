package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/3/29 14:44
 **/
public class LeetCode12 {

    public static void main(String[] args) {
        Solution solution = new LeetCode12().new Solution();
        System.out.println(solution.intToRoman2(1985));
    }

    class Solution {
        /**
         * 暴力破解
         * @param num
         * @return
         */
        public String intToRoman(int num) {
            StringBuilder res = new StringBuilder();
            int item = num / 1000;
            for (int i = 0; i < item; i++) {
                res.append('M');
            }
            num = num%1000;
            if (num >= 900){
                res.append("CM");
                num = num - 900;
            }
            if (num >= 500){
                num = num%500;
                res.append("D");
            }
            if (num >= 400){
                num = num%400;
                res.append("CD");
            }
            item = num/100;
            for (int i = 0; i < item; i++) {
                res.append('C');
            }
            num = num%100;
            if (num >= 90){
                res.append("XC");
                num = num - 90;
            }
            if (num >= 50){
                res.append("L");
                num = num - 50;
            }
            if (num >= 40){
                res.append("XL");
                num = num - 40;
            }
            item = num/10;
            for (int i = 0; i < item; i++) {
                res.append('X');
            }
            num = num%10;
            if (num >= 9){
                res.append("IX");
                num = num - 9;
            }
            if (num >= 5){
                res.append("V");
                num = num - 5;
            }
            if (num >= 4){
                res.append("IV");
                num = num - 4;
            }
            for (int i = 0; i < num; i++) {
                res.append("I");
            }
            return res.toString();
        }


        /**
         * 优化第一版
         * @param num
         * @return
         */
        public String intToRoman2(int num) {
            StringBuilder res = new StringBuilder();
            int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] arr2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int item = 0;
            for (int i = 0; i < arr.length; i++) {
                item = num / arr[i];
                for (int i1 = 0; i1 < item; i1++) {
                    res.append(arr2[i]);
                }
                num = num % arr[i];
            }
            return res.toString();
        }
    }
}
