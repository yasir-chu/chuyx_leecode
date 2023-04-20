package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/4/20 11:01
 */
public class LeetCode125 {

    public static void main(String[] args) {
        Solution solution = new LeetCode125().new Solution();
        System.out.println(solution.isPalindrome("1b1"));
    }


    class Solution {
        // 68.24 34.95
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int i = 0,j=s.length()-1;
            while (i<s.length() && j > 0){
                if (!Character.isLetterOrDigit(s.charAt(i))){
                    i++;
                    continue;
                }else if (!Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                    continue;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                if (i==j || Math.abs(j-i) == 1) {
                    break;
                }
                i++;
                j--;
            }
            return true;
        }



        public boolean isPalindrome2(String s) {
            int i = 0,j=s.length()-1;
            while (i<s.length() && j > 0){
                if (!Character.isLetterOrDigit(s.charAt(i))){
                    i++;
                    continue;
                }else if (!Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                    continue;
                }

                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                if (i==j || Math.abs(j-i) == 1) {
                    break;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
