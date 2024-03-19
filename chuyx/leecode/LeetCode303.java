package leecode;

/**
 * @author yuxiang_chu
 * @since 2024/3/18 11:14
 */
public class LeetCode303 {

    public static void main(String[] args) {
        int[] source = {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(source);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


    public static class NumArray {

        final int[] sumNums;


        public NumArray(int[] nums) {
            sumNums = new int[nums.length + 1];
            sumNums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sumNums[i+1] = sumNums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sumNums[right+1] - sumNums[left];
        }
    }
}
