package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiang_chu
 * @date 2022/11/4 11:17
 */
public class LeetCode754 {
    public static void main(String[] args) {
        Solution solution = new LeetCode754().new Solution();
        System.out.println(solution.reachNumber(-3));
    }



    class Solution {


        // 穷举
        public int reachNumber(int target) {
            int i = reachNum2(target, 0, 1, true);
            int i1 = reachNum2(target, 0, 1, false);
            int res = 0;
            if (i > 0 && i1 > 0) {
                return Math.min(i, i1);
            }else if (i > 0) {
                return i;
            }else if (i1 > 0) {
                return i1;
            }
            return 0;
        }

        public int reachNum2(int target, int now,int i, boolean isGo) {
            int newNow = isGo ? now + i : now -i ;
            int newI = i + 1;
            if (newNow == target) {
                return i;
            }
            if (Math.abs(newNow) > Math.abs(target)) {
                return -1;
            }
            int i1 = reachNum2(target, newNow, newI, true);
            if (i1 > 0) {
                return i1;
            }
            i1 = reachNum2(target, newNow, newI, false);
            if (i1 > 0) {
                return i1;
            }
            return -1;
        }
    }
}
