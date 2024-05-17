package leetcode;

/**
 * @author yuxiang.chu
 * @date 2022/6/30 9:59
 **/
public class LeetCode1175 {

    public static void main(String[] args) {
        Solution solution = new LeetCode1175.Solution();
        System.out.println(solution.numPrimeArrangements(100));
    }

    static class Solution {

        long mo = (int) (Math.pow(10, 9) + 7);

        public int numPrimeArrangements(int n) {
            int x = getPrimeNum(n);
            return Integer.parseInt(String.valueOf(factorial(x) * factorial(n - x) % mo));
        }

        private long factorial(int x) {
            long result = 1;
            for (long i = x; i >= 1; i--) {
                result = result * i % mo;
            }
            return result;
        }

        private int getPrimeNum(int n) {
            int result = 0;
            for (int i = 1; i < n + 1; i++) {
                if (isPrime(i)) {
                    result++;
                }
            }
            return result;
        }

        private boolean isPrime(int x) {
            if (x <= 1) {
                return false;
            }
            for (int i = 2; i * i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
