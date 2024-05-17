package leetcode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiang.chu
 * @date 2022/2/24 15:46
 **/
public class LeetCode77 {

    public static void main(String[] args) {
        Solution solution = new LeetCode77.Solution();
        List<List<Integer>> combine = solution.combine(9, 8);
        for (List<Integer> integers : combine) {
            System.out.println(integers);

        }
    }

    static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();

        public List<List<Integer>> combine(int n, int k) {

            f(n, k, 1);

            return result;
        }

        private void f(int n, int k, int i) {
            // 剪枝 这种情况下剩下的数字是无法拼接成一个k长度的数组的
            if (item.size() + (n - i + 1) < k) {
                return;
            }

            if (item.size() == k) {
                // 用新建实例对象的方式防止item 的变化影响到结果
                result.add(new ArrayList<>(item));
                return;
            }
            // 考虑当前位置
            item.add(i);

            f(n, k, i + 1);
            // 回溯 - 回复现场
            item.remove(item.size() - 1);
            // 不考虑当前位置
            f(n, k, i + 1);
        }
    }
}
