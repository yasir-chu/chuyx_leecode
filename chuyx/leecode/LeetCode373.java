package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yuxiang.chu
 * @date 2022/2/21 17:09
 **/
public class LeetCode373 {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            });
            List<List<Integer>> ans = new ArrayList<>();
            int m = nums1.length;
            int n = nums2.length;
            for (int i = 0; i < Math.min(m, k); i++) {
                pq.offer(new int[]{i,0});
            }
            while (k-- > 0 && !pq.isEmpty()) {
                int[] idxPair = pq.poll();
                ans.add(Arrays.asList(idxPair[0], idxPair[1]));

                if (idxPair[1] + 1 < n) {
                    pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
                }
            }

            return ans;
        }

    }
}
