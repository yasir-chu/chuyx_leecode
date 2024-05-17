package leetcode;

/**
 * @author yuxiang.chu
 * @date 2022/2/10 13:56
 **/
public class LeetCode278 {

    public static void main(String[] args) {
        Solution solution = new LeetCode278.Solution();
        System.out.println(solution.firstBadVersion2(1));
    }

    public static class Solution {
        // 二分法
        public int firstBadVersion(int n) {
            int start = 1;
            int mid = 0;
            while (start <= n) {
                mid = start + ((n - start) >> 1);
                if (isBadVersion(mid)) {
                    n = mid - 1;
                } else {
                    start = mid + 1;
                    mid = mid + 1;
                }
            }
            return isBadVersion(mid - 1) ? mid - 1 : mid;
        }

        // 遍历法
        public int firstBadVersion2(int n) {
            int i =1;
            while (i <= n){
                if (isBadVersion(i)){
                    return i;
                }
            }
            return 0;
        }

        // 别人的方法
        public int firstBadVersion3(int n) {
            int start = 1;
            // 因为 右节点没使用-1操作 所以这里不用《=
            while (start < n) {
                int mid = start + ((n - start) >> 1);
                if (isBadVersion(mid)) {
                    // 从当前开始
                    n = mid;
                } else {
                    start = mid + 1;
                }
            }
            // 直接用左标即可
            return start;
        }

        public boolean isBadVersion(int n) {
            if (n >= 1) {
                return true;
            }
            return false;
        }
    }
}
