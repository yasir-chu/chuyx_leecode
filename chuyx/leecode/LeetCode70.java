package leecode;

/**
 * @author yuxiang.chu
 */
public class LeetCode70 {
    public static void main(String[] args) {
        Solution solution = new LeetCode70().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int a = 1, b=0, c=0;
            for (int i = 1; i <= n; i++) {
                c=0;
                if (i == 1){
                    c = a;
                }
                if (i > 1){
                    c = b + a;
                }
                b=a;
                a=c;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}