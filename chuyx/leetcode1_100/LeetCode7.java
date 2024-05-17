package leetcode1_100;

/**
 * @author yuxiang_chu
 * @since 2024/5/14 15:55
 */
public class LeetCode7 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    static class Solution {

        /**
         * 耗时100
         * 内存87.86
         */
        public int reverse(int x) {
            int res = 0;
            while (true) {
                if (x / 10 == 0) {
                    res = res * 10 + (x % 10);
                    break;
                }
                res = res * 10 + (x % 10);
                //判断是否 大于 最大32位整数
                if (res>214748364 || (res==214748364 && (x % 10)>7)) { return 0; }
                //判断是否 小于 最小32位整数
                if (res<-214748364 || (res==-214748364 && (x % 10)<-8)) { return 0; }
                x = x / 10;
            }
            return res;

        }
    }
}
