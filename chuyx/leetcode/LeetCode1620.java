package leetcode;

/**
 * @author yuxiang_chu
 * @date 2022/11/2 16:44
 */
public class LeetCode1620 {


    public static void main(String[] args) {

    }

    static class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int xMax = 0,yMax = 0;
            for (int[] tower : towers) {
                xMax = Math.max(tower[0], xMax);
                yMax = Math.max(tower[1], yMax);
            }
            int[] res = new int[2];
            int maxP = 0;
            for (int i = 0; i <= xMax; i++) {
                for (int j = 0; j <= yMax; j++) {
                    int nowP = 0;
                    for (int[] tower : towers) {
                        // 计算当前节点信号
                        double lenthPow = Math.pow(tower[0] - i, 2) + Math.pow(tower[1] - j, 2);
                        if (lenthPow > radius * radius) {
                            continue;
                        }
                        nowP += Math.floor(tower[2] / (1 + Math.sqrt(lenthPow)));
                    }
                    if (maxP <= nowP) {
                        maxP = nowP;
                        if (res[0] <= i || res[1] <= j) {
                            res[0] = i;
                            res[1] = j;
                        }
                    }
                }
            }
            return res;
        }
    }
}
