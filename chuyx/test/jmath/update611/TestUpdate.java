package test.jmath.update611;

/**
 * 品喆 面试题 应还有优化点
 * @author yuxiang.chu
 * @date 2022/6/13 18:10
 **/
public class TestUpdate {


    public static void main(String[] args) {

    }

    public static Integer[][] update(Integer[][] req) {
        Integer[][] result = new Integer[req.length][req[0].length];
        for (int i = 0; i < req.length; i++) {
            for (int j = 0; j < req[i].length; j++) {
                result[i][j] = getResult(i, j, req, 0);
            }
        }
        return result;
    }

    private static Integer getResult(int i, int j, Integer[][] req, Integer sum) {
        for (int n = i - 1; n < req.length && n <= i + 1; n++) {
            for (int m = j - 1; m < req[n].length && m <= j + 1; m++) {
                if (n == i && m == j) {
                    continue;
                }
                calculation(m, n, req, sum);
            }
        }
        return getResultItem(req[i][j], sum);
    }

    private static Integer getResultItem(Integer integer, Integer sum) {
        if (integer == 1 && sum == 3) {
            return 1;
        }
        if (integer == 0 && sum == 2) {
            return 1;
        }
        return 0;
    }

    private static void calculation(int ni, int nj, Integer[][] req, Integer sum) {
        if (ni >= 0 && ni < req.length && nj >= 0 && nj <= req[ni].length && req[ni][nj] == 1) {
            ++sum;
        }
    }
}
