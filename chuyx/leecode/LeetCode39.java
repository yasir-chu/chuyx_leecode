package leecode;
//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
//
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
// 示例 4：
//
//
//输入: candidates = [1], target = 1
//输出: [[1]]
//
//
// 示例 5：
//
//
//输入: candidates = [1], target = 2
//输出: [[1,1]]
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯 👍 1558 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuxiang.chu
 * @date 2021/9/30 11:04
 **/
public class LeetCode39 {

    public static void main(String[] args) {
        Solution solution = new LeetCode39().new Solution();
        int[] a = {2,3,6,7};
        System.out.println(solution.combinationSum(a, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // 这个可排序可不排序  排序了可以在回溯递归中减少一定的回溯次数（通关判断当前值是否小于target 小于直接return）
            a(candidates, 0, target);
            return result.stream().distinct().collect(Collectors.toList());
        }

        public void a(int[] candidates, int u, int target){
            if (target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = u; i < candidates.length; i++) {
                if (candidates[i] <= target){
                    path.add(candidates[i]);
                    a(candidates, i, target - candidates[i]);
                    // 回溯现场   回溯算法的关键个人觉得
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
