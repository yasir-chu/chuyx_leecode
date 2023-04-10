package leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuxiang_chu
 * @date 2023/4/10 15:46
 */
public class LeetCode997 {


    public static void main(String[] args) {

    }


    class Solution {

        // 7.38 55.73
        public int findJudge(int n, int[][] trust) {
            if (trust.length <= 0 && n == 1) {
                return 1;
            }
            Map<Integer, Integer> map = new HashMap<>(n);
            Set<Integer> set = new HashSet<>(n);

            for (int[] ints : trust) {
                map.put(ints[1], map.getOrDefault(ints[1], 0) + 1);
                set.add(ints[0]);
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) == n - 1 && map.containsKey(key) && !set.contains(key)) {
                    return key;
                }
            }
            return -1;
        }


        // 96.51 84.45
        public int findJudge2(int n, int[][] trust) {
            // 入点
            int[] inDegrees = new int[n + 1];
            // 出点
            int[] outDegrees = new int[n + 1];
            // 提议就是 法官的入点为0 出点为n-1
            for (int[] edge : trust) {
                ++inDegrees[edge[1]];
                ++outDegrees[edge[0]];
            }
            for (int i = 1; i <= n; ++i) {
                if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                    return i;
                }
            }
            return -1;
        }
    }
}
