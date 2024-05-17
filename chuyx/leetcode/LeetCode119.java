package leetcode;

import java.util.ArrayList;
import java.util.List;
//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: rowIndex = 3
//输出: [1,3,3,1]
//
//
// 示例 2:
//
//
//输入: rowIndex = 0
//输出: [1]
//
//
// 示例 3:
//
//
//输入: rowIndex = 1
//输出: [1,1]
//
//
//
//
// 提示:
//
//
// 0 <= rowIndex <= 33
//
//
//
//
// 进阶：
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
// Related Topics 数组 动态规划 👍 323 👎 0
/**
 * @author yuxiang.chu
 * @date 2021/9/30 9:15
 **/
public class LeetCode119 {


    public static void main(String[] args) {
        Solution solution = new LeetCode119.Solution();
        System.out.println(solution.getRow(5));
    }


    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> last = new ArrayList<>();
            List<Integer> now = new ArrayList<>();
            for (int i = 1; i < rowIndex + 2; i++) {
                now = new ArrayList<>();
                if (i == 1) {
                    now.add(1);
                } else {
                    for (int j = 0; j < i; j++) {
                        if (j > 0 && j < last.size()) {
                            now.add(last.get(j) + last.get(j - 1));
                        } else {
                            now.add(1);
                        }
                    }
                }
                last = now;
            }
            return now;
        }
    }
}
